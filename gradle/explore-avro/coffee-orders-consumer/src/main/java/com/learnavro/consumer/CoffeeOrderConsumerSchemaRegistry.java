package com.learnavro.consumer;

import com.learnavro.domain.generated.CoffeeOrder;
import com.learnavro.domain.generated.CoffeeUpdateEvent;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author kansanja on 09/01/23.
 */
public class CoffeeOrderConsumerSchemaRegistry {
    private static final String COFFEE_ORDERS = "coffee-orders-sr";
    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderConsumerSchemaRegistry.class);

    public static void main(String[] args){

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        properties.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        properties.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG , "greeting.consumer");

//        KafkaConsumer<OrderId, CoffeeOrder> consumer = new KafkaConsumer<>(properties);
        KafkaConsumer<String, GenericRecord> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singletonList(COFFEE_ORDERS));
        log.info("Consumer started");
        while (true){
//            ConsumerRecords<OrderId, CoffeeOrder> records = consumer.poll(Duration.ofMillis(100));
            ConsumerRecords<String, GenericRecord> records = consumer.poll(Duration.ofMillis(100));
//            for(ConsumerRecord<OrderId, CoffeeOrder> record : records){
          for(ConsumerRecord<String, GenericRecord> record : records){
                try {
//                    coffeeOrder = decodeCoffeeOrder(record.value());
                    log.info("Consumed Message , key : {} , value : {}", record.key() , record.value().toString());
                    var genericRecord = record.value();
                    if(genericRecord instanceof CoffeeOrder){
                        var coffeeOrder = (CoffeeOrder) genericRecord;
                        log.info("CoffeeOrder: {}",coffeeOrder);

                    }else if(genericRecord instanceof CoffeeUpdateEvent){
                        var coffeeUpdateEvent = (CoffeeUpdateEvent) genericRecord;
                        log.info("CoffeeUpdateEvent: {}",coffeeUpdateEvent);
                    }

//                    var cstTime= LocalDateTime.ofInstant(coffeeOrder.getOrderedTime(), ZoneId.of("America/Chicago"));
//                    var utcTime= LocalDateTime.ofInstant(coffeeOrder.getOrderedTime(), ZoneOffset.UTC);
//                    log.info("utcDateTime: {} & cstDateTime: {}",utcTime,cstTime);
                } catch (Exception e) {
                    log.error("Exception is : {}", e.getMessage() , e);
                }

            }
        }
    }

    private static CoffeeOrder decodeCoffeeOrder(byte[] array) throws IOException {
        return CoffeeOrder.fromByteBuffer(ByteBuffer.wrap(array));
    }

}
