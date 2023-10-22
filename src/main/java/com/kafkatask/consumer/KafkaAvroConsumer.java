package com.kafkatask.consumer;

import com.kafkatask.schema.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaAvroConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaAvroConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.avro}")
    public void listen(@Payload Book book) {
        logger.info("Receiving book: " + book);
    }
}
