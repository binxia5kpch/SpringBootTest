import com.alibaba.fastjson.JSON
import com.google.gson.Gson
import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

String a="""
{
    "category_contitions": {
        "56c6a4fac2fb4e0ea400002a": [
                {
                    "category_name": "葡萄酒"
                }
        ]
    },
    "product_list": [
        {
            "id": "58fad70eaf484341f632a16c",
            "qrcode": "3250390801078",
            "title": "卡斯德堡赤霞珠干红葡萄酒 750ml",
            "price": 99,
            "avatar_url": "http://img.51xiaoniu.cn/product/main_assets/assets/58fa/d7ac/206a/af1a/51be/f4b6/58fad73aaf484341f332a1c4.jpg@!avatar",
             "thumb_url": "http://img.51xiaoniu.cn/product/main_assets/assets/570e/4b39/206a/af31/6024/fece/570b0a88af48433f03be7c8b.jpg@!thumb",
            "marketPrice": 139,
            "mobile_category_id": "56c6a4fac2fb4e0ea400002a",
            "category_name": "葡萄酒"
        },
        {
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
]
}

"""


def dingceng=[:];
idcateMap=[:]
def cateNextlist=[]
def nextCateMap=[:]
nextCateMap.put("category_name","葡萄酒")
cateNextlist.add(nextCateMap)
idcateMap.put("56c6a4fac2fb4e0ea400002a",cateNextlist)
dingceng.put("category_contitions",idcateMap)


def productTopMap=[:]
def productList=[]
def productMap=[:]
productMap.put("id","58fad70eaf484341f632a16c")
productMap.put("qrcode","3250390801078")
productMap.put("title","卡斯德堡赤霞珠干红葡萄酒 750ml")
productMap.put("price","99")
productMap.put("avatar_url","http://img.51xiaoniu.cn/product/main_assets/assets/58fa/d7ac/206a/af1a/51be/f4b6/58fad73aaf484341f332a1c4.jpg@!avatar")
productMap.put("thumb_url","http://img.51xiaoniu.cn/product/main_assets/assets/570e/4b39/206a/af31/6024/fece/570b0a88af48433f03be7c8b.jpg@!thumb")
productMap.put("marketPrice","139")
productMap.put("mobile_category_id","56c6a4fac2fb4e0ea400002a")
productMap.put("category_name","葡萄酒")


productList.add(productMap)
def productMap1=[:]
productMap1.put("id","58fad70eaf484341f632a16c")
productMap1.put("qrcode","3250390801078")
productMap1.put("title","卡斯德堡赤霞珠干红葡萄酒 70ml")


productMap1.put("price","198")
productMap1.put("avatar_url","http://img.51xiaoniu.cn/product/main_assets/assets/570e/4b39/206a/af31/6024/fece/570b0a88af48433f03be7c8b.jpg@!avatar")
productMap1.put("thumb_url","http://img.51xiaoniu.cn/product/main_assets/assets/570e/4b39/206a/af31/6024/fece/570b0a88af48433f03be7c8b.jpg@!thumb")
productMap1.put("marketPrice","238")
productMap1.put("mobile_category_id","56c6a4fac2fb4e0ea400002a")
productMap1.put("category_name","葡萄酒")


productList.add(productMap1)
dingceng.put("product_list",productList)


//dingceng.add(categ)
//dingceng.add(productTopMap)

//println Gson.toJson(productMap)

out << JSON.toJSONString(dingceng)