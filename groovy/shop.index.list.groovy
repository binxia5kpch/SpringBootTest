import com.alibaba.fastjson.JSON
import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")

def productList=[]


goodsMysql.shopMysql.eachRow("select * from shop_goods where is_index=1",{
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