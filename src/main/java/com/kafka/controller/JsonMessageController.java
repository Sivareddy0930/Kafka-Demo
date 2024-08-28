package com.kafka.controller;

import com.kafka.payload.User;
import com.kafka.producers.KafkaJsonProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class JsonMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageController.class);

    private KafkaJsonProducer producer;

    public JsonMessageController(KafkaJsonProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        producer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to Kafka Topic");
    }
}
