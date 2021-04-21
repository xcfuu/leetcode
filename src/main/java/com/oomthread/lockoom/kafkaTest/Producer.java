package com.oomthread.lockoom.kafkaTest;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Producer {
    public static String topic = "wentai_test";//定义主题

    public static void main(String[] args) throws InterruptedException {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.102.102:9092");//kafka地址，多个地址用逗号分割
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p);
        int i=0;
        try {
            while (i<3) {
                i++;
                String msg = "Hello," + new Random().nextInt(100)+"    顺序："+i;
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, msg);
                Future<RecordMetadata> recordMetadataFuture = kafkaProducer.send(record);
                try {
                    RecordMetadata metadata = recordMetadataFuture.get();
                    System.out.println("消息：------"+metadata.toString());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println("消息发送成功:" + msg);
                Thread.sleep(500);
            }
        } finally {
            kafkaProducer.close();
        }

    }
}
