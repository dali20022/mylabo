package com.clevertech.mylabo.web.rest;

import com.clevertech.mylabo.service.MylaboKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mylabo-kafka")
public class MylaboKafkaResource {

    private final Logger log = LoggerFactory.getLogger(MylaboKafkaResource.class);

    private MylaboKafkaProducer kafkaProducer;

    public MylaboKafkaResource(MylaboKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
