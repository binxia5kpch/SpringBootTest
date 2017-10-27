package com.zhongsou.kafka.test

/**
 * Created by Administrator on 2017/5/9.
 */
class KafkaProperties {
    final static String zkConnect = "103.29.134.71:5180";
    final static String groupId = "group1";
    final static String topic = "topic1";
    final static String brokerList = "103.29.134.71:9030"
    final static String kafkaServerURL = "103.29.134.71";
    final static int kafkaServerPort = 9030;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";
}
