package com.zhongsou.core.conf

import com.zhongsou.util.DBUtils
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CfgDatabase {

//    String shopUrl="jdbc:mysql://13.115.96.144:3306/shopdata?characterEncoding=UTF-8&autoReconnect=true";
//    String shopUser="kangmysql";
//    String shopPsw="kangmysql";
//    @Bean
//    Sql shopMysql() {
//        DBUtils.newSql(shopUrl, shopUser, shopPsw)
//    }

    @Bean
    Sql shopMysql(@Value('${db.mysql.shop.url}') String shopUrl,@Value('${db.mysql.shop.user}') String shopUser,@Value('${db.mysql.shop.password}') String shopPsw){
        DBUtils.newSql(shopUrl, shopUser, shopPsw)
    }
//    @Bean
//    LiveMongodb hemsMongodb(
//        @Value('${live.mongo.servers}') String servers,
//        @Value('${live.mongo.db}') String dbName) {
//        new LiveMongodb(servers, dbName)
//    }



}
