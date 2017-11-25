import com.alibaba.fastjson.JSON
import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

import javax.servlet.http.HttpServletRequest

HttpServletRequest hs = request as HttpServletRequest

System.out.println("regId==>"+hs.getParameter("regId"));

String addressType= hs.getParameter("addressType")
GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")

def backMap=[:];
if(addressType.equals("insert")){
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
        addressList<<[
                id:it.id,
                userid:it.userid,
                username:it.username,
                mobile:it.mobile,
                address:it.address,
                school:it.school,
                isdefault:it.isdefault
        ]
    })
    backMap.put("addressList",addressList)
}else if (addressType.equals("update")){
    goodsMysql.shopMysql.executeUpdate("UPDATE shop_user_address SET username = ?,mobile=?,address=?,school=?,isdefault=? WHERE userid = ?",
    [username,mobile,address,school,defalutFlag,userid])
}

out << JSON.toJSONString(backMap);