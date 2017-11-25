import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

import javax.servlet.http.HttpServletRequest

HttpServletRequest hs = request as HttpServletRequest

System.out.println("regId==>"+hs.getParameter("regId"));

String addressType= hs.getParameter("addressType")

if(addressType.equals("insert")){
    String userid= hs.getParameter("userid")
    String username= hs.getParameter("username")
    String mobile= hs.getParameter("mobile")
    String address= hs.getParameter("address")
    String school= hs.getParameter("school")
    String isdefault= hs.getParameter("isdefault")
    GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")
    def orderId = goodsMysql.shopMysql.executeInsert("insert into shop_user_address(userid,username,mobile,address,school,isdefault) values(?,?,?,?,?,?)",
            [userid,username,mobile,address,school,isdefault])
}