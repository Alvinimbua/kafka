package com.imbuka.kafka.controller;

import com.imbuka.kafka.dto.Customer;
import com.imbuka.kafka.kafka.JsonKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class JsonMessageController {

    private final JsonKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish (@RequestBody Customer customer) {
        kafkaProducer.sendMessage(customer);
        return ResponseEntity.ok("Json message sent to Kafka topic");

    }
}
