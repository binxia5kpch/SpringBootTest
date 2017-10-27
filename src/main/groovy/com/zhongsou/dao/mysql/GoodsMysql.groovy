package com.zhongsou.dao.mysql

import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by Administrator on 2017/10/14.
 */
@Repository
class GoodsMysql {
    @Autowired
    Sql shopMysql

    public int getMyFansCount(){
        String sql = "select count(1) as count from live_user_fans ";
        def ret = shopMysql.firstRow(sql)
        return ret.count
    }
}
