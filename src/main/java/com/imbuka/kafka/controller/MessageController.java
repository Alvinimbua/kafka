package com.imbuka.kafka.controller;

import com.imbuka.kafka.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    //http:localhost:8080/api/v1/kafka/publish?message=hello Alvin
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
         kafkaProducer.sendMessage(message);
         return ResponseEntity.ok("Message sent to the topic");

    }
}
