import com.alibaba.fastjson.JSON
import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

import javax.servlet.http.HttpServletRequest

HttpServletRequest hs = request as HttpServletRequest



String addressType= hs.getParameter("addressType")
GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")

def backMap=[:];
String userid= hs.getParameter("userid")
String username= hs.getParameter("username")
String mobile= hs.getParameter("mobile")
String address= hs.getParameter("address")
String school= hs.getParameter("school")
String isdefault= hs.getParameter("isdefault")
int defalutFlag=0
if(isdefault){
    defalutFlag=1
}
if(addressType.equals("insert")){

    def countRet = goodsMysql.shopMysql.firstRow("select count(*) as count from shop_user_address where userid=?",[userid])
    System.out.println("regId==>"+countRet);
    if(countRet.count<1){
        defalutFlag=1
    }
    def insertId = goodsMysql.shopMysql.executeInsert("insert into shop_user_address(userid,username,mobile,address,school,isdefault) values(?,?,?,?,?,?)",
            [userid,username,mobile,address,school,defalutFlag])

    backMap.put("insertId",insertId)
}else if(addressType.equals("delete")){
    String id=hs.getParameter("id")
    if(id){
        goodsMysql.shopMysql.executeUpdate("delete from shop_user_address where id=?",[id])
    }else{
        backMap.put("mess","id 不能为空")
    }

}else if(addressType.equals("query")){
    def addressList=[]
    goodsMysql.shopMysql.eachRow("select * from shop_user_address WHERE userid = ?",[userid],{
        int defaultInt = it.isdefault as int
        addressList<<[
                id:it.id,
                userid:it.userid,
                username:it.username,
                mobile:it.mobile,
                address:it.address,
                school:it.school,
                isdefault: defaultInt==1?"success_circle":"circle"
        ]
    })
    backMap.put("addressList",addressList)
}else if (addressType.equals("update")){
    int updateRet = goodsMysql.shopMysql.executeUpdate("UPDATE shop_user_address SET username = ?,mobile=?,address=?,school=?,isdefault=? WHERE userid = ?",
    [username,mobile,address,school,defalutFlag,userid])
    backMap.put("updateRet",updateRet)
}else if(addressType.equals("updateDefault")){
    String id=hs.getParameter("id")
    if(id){
        goodsMysql.shopMysql.executeUpdate("UPDATE shop_user_address SET isdefault = ? where id=?",[defalutFlag,id])
    }else{
        backMap.put("mess","id 不能为空")
    }
}

out << JSON.toJSONString(backMap);