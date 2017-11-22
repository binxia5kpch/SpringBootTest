import com.alibaba.fastjson.JSON
import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

import javax.servlet.http.HttpServletRequest

/**
 * 通过分类查询商品列表
 */
GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")



HttpServletRequest re = request as HttpServletRequest
String cateId = re.getParameter("cateId");




def productList=[]


goodsMysql.shopMysql.eachRow("select * from shop_goods where mobile_category_id=?",[cateId],{
    productList<<[
            id:it.id,
            qrcode:it.qrcode,
            title:it.title,
            price:it.price,
            avatar_url:it.avatar_url,
            thumb_url:it.thumb_url,
            marketPrice:it.market_price,
            mobile_category_id:it.mobile_category_id,
            category_name:it.category_name
    ]
})

out << JSON.toJSONString(productList)