package com.thinker.util;

import com.thinker.model.Student;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.alibaba.fastjson.JSON;

import java.util.Properties;

/**
 * @author zeekling [lingzhaohui@zeekling.cn]
 * @version 1.0
 * @apiNote
 * @since 2020-05-05
 */
public class KafkaUtils2 {


    private static final String broker_list = "localhost:9092";
    private static final String topic = "student-write";  //kafka topic 需要和 flink 程序用同一个 topic

    private static void writeToKafka() throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", broker_list);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<String, String>(props);

        for (int i = 1; i <= 200; i++) {
            Student student = new Student(i, "baiyu" + i, "password" + i, 18 + i);
            ProducerRecord record = new ProducerRecord<String, String>(topic, null, null, JSON.toJSONString(student));
            producer.send(record);
            System.out.println("发送数据: " + JSON.toJSONString(student));
        }
        producer.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        writeToKafka();
    }

}
