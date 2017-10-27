package cn.jpush.api;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import groovy.json.JsonOutput;
import groovy.json.JsonSlurper;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/26.
 */
public class ClientTest {

    public static void main(String[] args) throws APIConnectionException, APIRequestException {



        JPushClient jpushClient =  new JPushClient("6815e5572e91a870b4f278a8", "d806f1c8d5bb2138e469137c", 3);
        String title="中纪委披露贪官奢靡生活 34万长期住酒店";
        //String alert="[新闻早餐]揭贪官34万长期住酒店奢靡生活；银行卡刷卡手续费今起下调；妻子喜欢“买买买”被丈夫暴打。"
        String extraText="{\"data\":{\"docId\":\"http://z.zhongsou.net/news/080808_7138647.html\",\"docType\":\"1\",\"invoke\":\"10\",\"keyword\":\"新闻三分钟\",\"sprId\":\"cca884e36add7e8742411a31be2c0e05\"},\"desc\":\"[新闻早餐]揭贪官34万长期住酒店奢靡生活；银行卡刷卡手续费今起下调；妻子喜欢“买买买”被丈夫暴打。\",\"time\":1473118609000,\"title\":\"中纪委披露贪官奢靡生活 34万长期住酒店\",\"type\":\"news\"}";
        String regId="120c83f76020db8210a";


        Map extra= new HashMap();
        extra.put("jumpTo",extraText);

//PushResult result = jpushClient.sendAndroidNotificationWithRegistrationID(title.toString(), alert, extra, regId)


//msg_content	string	必填	消息内容本身
//title	string	可选	消息标题
//content_type	string	可选	消息内容类型
//extras	JSON Object	可选	JSON 格式的可选参数
        PushResult result=jpushClient.sendAndroidMessageWithRegistrationID(title,JsonOutput.toJson(extra),regId);
        System.out.print(result);

    }

}
