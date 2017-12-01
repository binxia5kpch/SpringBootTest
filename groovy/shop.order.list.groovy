import com.alibaba.fastjson.JSON
import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

import javax.servlet.http.HttpServletRequest


HttpServletRequest hs = request as HttpServletRequest
GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")

def orderList = []

goodsMysql.shopMysql.eachRow("select * from shop_order where userid=?",[hs.getParameter("userid")],{ order->
    System.out.println(order.id);
    System.out.println(hs.getParameter("userid"));
    def orderLineList=[]
    goodsMysql.shopMysql.eachRow("select sol.id as lineId,sol.num as buy, sg.id as goodsId,sg.title,sg.avatar_url,sg.thumb_url,sg.price,sg.market_price ,sg.mobile_category_id,sg.category_name " +
            "from shop_order_line sol left join shop_goods sg on sg.id = sol.goods_id where order_id=?",[order.id],{ line->
        //System.out.println("==>"+line.lineId)
        orderLineList<<[
                lineId:line.lineId,
                goodsId:line.goodsId,
                title:line.title,
                price:line.price,
                avatar_url:line.avatar_url,
                thumb_url:line.thumb_url,
                marketPrice:line.market_price,
                mobile_category_id:line.mobile_category_id,
                category_name:line.category_name,
                buy:it.buy
        ]
    })

    orderList <<[
            remark:order.remark,
            total_amt: order.total_amt,
            orderLineList : orderLineList
    ]
})

out << JSON.toJSONString(orderList)

