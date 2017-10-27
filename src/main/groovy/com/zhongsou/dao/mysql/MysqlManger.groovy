package com.zhongsou.dao.mysql

import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by Administrator on 2017/10/15.
 */
@Repository
class MysqlManger {
    @Autowired
    Sql shopMysql
}
