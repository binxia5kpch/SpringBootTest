import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.springboot.test.TestClassLoaderService1
import com.zhongsou.util.BeanUtils

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest

/**
 *
 *         {
 "id": "570b0a7daf48433ef7be7cbf",
 "qrcode": "7804300136291",
 "title": "圣梅兰梅洛干红葡萄酒 750ml",
 "price": 198,
 "avatar_url": "http://img.51xiaoniu.cn/product/main_assets/assets/570e/4b39/206a/af31/6024/fece/570b0a88af48433f03be7c8b.jpg@!avatar",
 "thumb_url": "http://img.51xiaoniu.cn/product/main_assets/assets/570e/4b39/206a/af31/6024/fece/570b0a88af48433f03be7c8b.jpg@!thumb",
 "marketPrice": 238,
 "mobile_category_id": "56c6a4fac2fb4e0ea400002a",
 "category_name": "葡萄酒"
 }
 *
 *
 */



HttpServletRequest re = request as HttpServletRequest

def name  = re.getParameter("name");
def category_name =re.getParameter("category_name");
def price =re.getParameter("price");
def avatar_url =re.getParameter("avatar_url");
def marketPrice =re.getParameter("marketPrice");
