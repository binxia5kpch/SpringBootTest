import javax.servlet.http.HttpServletRequest

/**
 * Created by Administrator on 2017/8/21.
 */

//import com.zhongsou.dao.mysql.GoodsMysql
//import com.zhongsou.springboot.test.TestClassLoaderService1
//import com.zhongsou.util.BeanUtils
//
//
//TestClassLoaderService1 t2 = BeanUtils.getBean("testClassLoaderService1")
//t2.hh1();
//println "====>hahah3";
//
//GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")
//
//String sql = "select *  from shop_goods ";
//def ret = goodsMysql.shopMysql.firstRow(sql)
//println "ret===>"+ret
//
//
////println goodsMysql.myFansCount

println request.getParameter("re");
//println code


//title: "卡斯德堡赤霞珠干红葡萄酒 750ml",
//price: "99",
//avatar_url: "http://img.51xiaoniu.cn/product/main_assets/assets/58fa/d7ac/206a/af1a/51be/f4b6/58fad73aaf484341f332a1c4.jpg@!avatar",
//thumb_url: "http://img.51xiaoniu.cn/product/main_assets/assets/570e/4b39/206a/af31/6024/fece/570b0a88af48433f03be7c8b.jpg@!thumb",
//marketPrice: "139",
//mobile_category_id: "56c6a4fac2fb4e0ea400002a",
//category_name: "葡萄酒"

HttpServletRequest re = request as HttpServletRequest

String title=re.getParameter("title")
String inser
println title;

out<< "aaaa"