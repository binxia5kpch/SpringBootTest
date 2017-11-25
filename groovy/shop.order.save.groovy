import cn.jpush.api.JPushClient
import cn.jpush.api.push.PushResult
import com.alibaba.fastjson.JSON
import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

import javax.servlet.http.HttpServletRequest

/**
 * remark
 username
 userid
 mobile

 goods_id
 price
 num

 */



HttpServletRequest re = request as HttpServletRequest

// 读取请求内容
BufferedReader br = new BufferedReader(new InputStreamReader(re.getInputStream()));
String line = null;
StringBuilder sb = new StringBuilder();
while((line = br.readLine())!=null){
    sb.append(line);
}

// 将资料解码
String reqBodyStr =  sb.toString();
//String reqBodyStr="""
//{"remark":"1","goodList":"[{\\"id\\":1,\\"qrcode\\":\\"1\\",\\"title\\":\\"康师傅方便面\\",\\"price\\":5,\\"avatar_url\\":\\"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2666833431,2276984962&fm=27&gp=0.jpg\\",\\"thumb_url\\":\\"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2666833431,2276984962&fm=27&gp=0.jpg\\",\\"marketPrice\\":10,\\"mobile_category_id\\":1,\\"category_name\\":\\"方便面\\",\\"buy\\":1,\\"icon_circle\\":\\"success_circle\\"}]","userid":"o8T0R0dnMvt7YLA-zlYw0Kw0sqS4"}
//
//"""
System.out.println("reqBodStr==>"+reqBodyStr);

def headObject = JSON.parseObject(reqBodyStr);

String remark = headObject.remark;
//String username = headObject.getParameter("username");
String userid = headObject.userid;
System.out.println("userId==>"+userid)
//def goodString = ob.goodList
//System.out.println(goodString);
def goodsList = JSON.parse(headObject.goodList);
int total_amt;
goodsList?.each {it->
    total_amt=total_amt+(it.price as int)

}
//查询用户信息
GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")
def userInfo = goodsMysql.shopMysql.firstRow("select * from shop_user_info where userid=?",[userid])

System.out.println("userInfo==>"+userInfo);
//保存主表：

def orderId = goodsMysql.shopMysql.executeInsert("insert into shop_order(code,total_amt,remark,username,userid,mobile) values(?,?,?,?,?,?)",
        ["1",total_amt,remark,userInfo.username,userid,userInfo.mobile])
System.out.println("orderId===>"+orderId[0][0])

goodsList?.each { it->
    def ret = goodsMysql.shopMysql.executeInsert("insert into shop_order_line(order_id,goods_id,goods_name,categroy_id,price,num,amt) values(?,?,?,?,?,?,?)",
    [orderId[0][0],it.id,it.title,it.mobile_category_id,it.price,it.buy,(it.buy as int)*(it.price as int)])

    System.out.println("ret==>"+ret);
}

//推送订单消息

goodsMysql.shopMysql.eachRow("select * from shop_app_info",{
    try{
        pushMessage(it.regId,goodString);
    }catch(Exception e){}

})


public void pushMessage(def regId,def goodString){
    JPushClient jpushClient =  new JPushClient("6815e5572e91a870b4f278a8", "d806f1c8d5bb2138e469137c", 3);
    String title='中纪委披露贪官奢靡生活 34万长期住酒店';
    String alert="[新闻早餐]揭贪官34万长期住酒店奢靡生活；银行卡刷卡手续费今起下调；妻子喜欢“买买买”被丈夫暴打。"
    //String extraText='''{"data":{"docId":"http://z.zhongsou.net/news/080808_7138647.html","docType":"1","invoke":"10","keyword":"新闻三分钟","sprId":"cca884e36add7e8742411a31be2c0e05"},"desc":"[新闻早餐]揭贪官34万长期住酒店奢靡生活；银行卡刷卡手续费今起下调；妻子喜欢“买买买”被丈夫暴打。","time":1473118609000,"title":"中纪委披露贪官奢靡生活 34万长期住酒店","type":"news"}''';
   // String regId = hs.getParameter("regId");

    JsonSlurper jsonSlurper=new JsonSlurper();
    Map extra= [:]
    extra.jumpTo=goodString;
//print extra.jumpTo;

//PushResult result = jpushClient.sendAndroidNotificationWithRegistrationID(title.toString(), alert, extra, regId)
//msg_content	string	必填	消息内容本身
//title	string	可选	消息标题
//content_type	string	可选	消息内容类型
//extras	JSON Object	可选	JSON 格式的可选参数
    PushResult result=jpushClient.sendAndroidMessageWithRegistrationID(title,JsonOutput.toJson(extra),regId);
}

System.out.println("remark==>"+remark+"username==>"+username)

