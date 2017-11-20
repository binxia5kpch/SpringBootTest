import com.alibaba.fastjson.JSON

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

def backMap=[:]
def carousel_list=[];

def categoryMap=[:]

categoryMap.put("id","5922bed95b73291ab08800c2")
categoryMap.put("field_mark","6")
categoryMap.put("event_mark","0")
categoryMap.put("img","/system/carousel_applies/avatars/5922/bed9/5b73/291a/b088/00c1/original/0522%E5%A4%A9%E6%9C%9D%E4%B8%8A%E5%93%81%E8%B4%B5%E4%BA%BA%E9%85%92%E8%BD%AE%E6%92%AD.jpg?1495449305")
carousel_list.add(categoryMap)

def categoryMap1=[:]

categoryMap1.put("id","5954cd0d5b73294d45cbd71f")
categoryMap1.put("field_mark","3")
categoryMap1.put("event_mark","3")
categoryMap1.put("img","/system/carousel_applies/avatars/5954/cc9d/5b73/294d/497e/121c/original/QQ%E5%9B%BE%E7%89%8720170628132417.jpg?1498729629")
carousel_list.add(categoryMap1)

backMap.put("carousel_list",carousel_list)


out << JSON.toJSONString(backMap)