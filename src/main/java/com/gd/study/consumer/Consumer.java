package com.gd.study.consumer;

import com.gd.study.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class Consumer {

    /*@KafkaListener(topics = "user")
    public void consumer(ConsumerRecord consumerRecord){
        Optional<Object> kafkaMsg = Optional.ofNullable(consumerRecord.value());
        if(kafkaMsg.isPresent()){
            Object obj = kafkaMsg.get();
            System.out.println(obj);
        }
    }*/
    @KafkaListener(topics = Product.TOPIC_TEST, groupId = Product.TOPIC_GROUP1)
    public void topic_test(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("topic_test 消费了： Topic:" + topic + ",Message:" + msg);
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = Product.TOPIC_TEST, groupId = Product.TOPIC_GROUP2)
    public void topic_test1(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("topic_test1 消费了： Topic:" + topic + ",Message:" + msg);
            ack.acknowledge();
        }
    }
}
