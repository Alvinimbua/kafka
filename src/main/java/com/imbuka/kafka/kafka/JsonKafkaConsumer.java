package com.imbuka.kafka.kafka;

import com.imbuka.kafka.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "transactions_json", groupId = "myGroup")
    public void consume(Customer customer) {
        LOGGER.info(String.format("Json message received -> %s", customer.toString()));

    }
}
