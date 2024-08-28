package com.kafka.producers;

import com.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,topicJsonName)
                .build();


        LOGGER.info("Sending JSON message to KafkaTopic" + user.toString());
        kafkaTemplate.send(message);
    }

}
