import com.zhongsou.dao.mysql.GoodsMysql
import com.zhongsou.util.BeanUtils

import javax.servlet.http.HttpServletRequest

HttpServletRequest re = request as HttpServletRequest

String regId = re.getParameter("regId");

GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")
goodsMysql.shopMysql.executeInsert("insert into shop_app_info(regId) values(?)",[regId])