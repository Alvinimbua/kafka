package com.imbuka.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic transaction() {
        return TopicBuilder.name("transactions")
                .build();
    }

    @Bean
    public NewTopic transactionJson() {
        return TopicBuilder.name("transactions_json")
                .build();
    }
}
