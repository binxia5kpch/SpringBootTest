import com.alibaba.fastjson.JSON
import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

String a="""

carousel_list: [
{
id: "5954cd0d5b73294d45cbd71f",
field_mark: "3",
event_mark: 3,
event_memo: "5954cbd35b73294d45cbd71d",
img: "/system/carousel_applies/avatars/5954/cc9d/5b73/294d/497e/121c/original/QQ%E5%9B%BE%E7%89%8720170628132417.jpg?1498729629",
product_group_title: "啤酒特特卖",
url: null
},
{
id: "595378685b73294d4d417429",
field_mark: 5,
event_mark: 0,
event_memo: "",
img: "/system/carousel_applies/avatars/59c2/2e9a/5b73/2947/0e20/e380/original/%E8%BD%AE%E6%92%AD5.jpg?1505898138",
url: null
},
{
id: "5922bed95b73291ab08800c2",
field_mark: 6,
event_mark: 0,
event_memo: "",
img: "/system/carousel_applies/avatars/5922/bed9/5b73/291a/b088/00c1/original/0522%E5%A4%A9%E6%9C%9D%E4%B8%8A%E5%93%81%E8%B4%B5%E4%BA%BA%E9%85%92%E8%BD%AE%E6%92%AD.jpg?1495449305",
url: null
}
]

"""

//out <<a
GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")
def backMap=[:]
def carousel_list=[];

goodsMysql.shopMysql.eachRow("select * from shop_cagtegory where ishot=1",{
    carousel_list<<[
            id:it.id,
            name:it.name,
            event_mark:"3",
            img:it.img
    ]
})

//def categoryMap=[:]
//
//categoryMap.put("id","5922bed95b73291ab08800c2")
//categoryMap.put("event_mark","3")
//categoryMap.put("img","https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=3673401264,4261410059&fm=85&s=58D3709A4EDA75E7781B51840300F0A8")
//carousel_list.add(categoryMap)
//
//def categoryMap1=[:]
//
//categoryMap1.put("id","5954cd0d5b73294d45cbd71f")
//categoryMap1.put("event_mark","3")
//categoryMap1.put("img","https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3842027919,3501108524&fm=58&u_exp_0=3274994304,3167803114&fm_exp_0=86&bpow=240&bpoh=237")
//carousel_list.add(categoryMap1)

backMap.put("carousel_list",carousel_list)


out << JSON.toJSONString(backMap)