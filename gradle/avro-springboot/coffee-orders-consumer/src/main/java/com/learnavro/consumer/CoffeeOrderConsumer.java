package com.learnavro.consumer;

import com.learnavro.domain.generated.CoffeeOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author kansanja on 12/01/23.
 */
@Component
@Slf4j
public class CoffeeOrderConsumer {

    @KafkaListener(topics = {"coffee-orders"}, groupId = "${spring.kafka.consumer.group-id}")
    public void onMessage(ConsumerRecord<String, GenericRecord> genericRecord){
        log.info("ConsumerRecord key is {} and the value is {}", genericRecord.key(),genericRecord.value());
    }
}
