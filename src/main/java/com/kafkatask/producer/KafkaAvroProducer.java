package com.kafkatask.producer;

import com.kafkatask.schema.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaAvroProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaAvroProducer.class);

    @Value("${spring.kafka.topic.avro}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;

    public void sendMessage(Book book) {
        logger.info("Sending message: " + book);
        kafkaTemplate.send(topicName, book);
    }
}
