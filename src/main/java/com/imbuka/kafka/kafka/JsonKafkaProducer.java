package com.imbuka.kafka.kafka;

import com.imbuka.kafka.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Customer> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Customer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Customer data) {

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<Customer> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "transactions_json")
                .build();

        kafkaTemplate.send(message);
    }
}
