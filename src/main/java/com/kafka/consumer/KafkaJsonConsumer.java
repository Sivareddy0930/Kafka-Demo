package com.kafka.consumer;

import com.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consumeJson(User user){

        logger.info("Consumed Java Object : " + user.toString());  // Print the consumed Java Object to the console.

    }
}
