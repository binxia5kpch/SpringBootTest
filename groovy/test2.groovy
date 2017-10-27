import com.zhongsou.util.BeanUtils
import com.zhongsou.dao.mysql.GoodsMysql

println  "hahah2"


GoodsMysql goodsMysql = BeanUtils.getBean("goodsMysql")
goodsMysql.getMyFansCount();

