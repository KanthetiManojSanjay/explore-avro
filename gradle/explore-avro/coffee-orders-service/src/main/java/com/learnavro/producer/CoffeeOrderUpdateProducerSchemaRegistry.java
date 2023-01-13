package com.learnavro.producer;

import com.learnavro.domain.generated.CoffeeUpdateEvent;
import com.learnavro.domain.generated.OrderId;
import com.learnavro.domain.generated.OrderStatus;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.serializers.subject.RecordNameStrategy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * @author kansanja on 07/01/23.
 */
public class CoffeeOrderUpdateProducerSchemaRegistry {
    private static final String COFFEE_ORDERS = "coffee-orders-sr";
    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderUpdateProducerSchemaRegistry.class);

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        properties.put(KafkaAvroSerializerConfig.VALUE_SUBJECT_NAME_STRATEGY, RecordNameStrategy.class.getName());

        KafkaProducer<String, CoffeeUpdateEvent> producer = new KafkaProducer<String, CoffeeUpdateEvent>(properties);

        CoffeeUpdateEvent coffeeUpdateEvent = buildCoffeeUpdateEvent();

        ProducerRecord<String, CoffeeUpdateEvent> producerRecord = new ProducerRecord<>(COFFEE_ORDERS, coffeeUpdateEvent.getId().toString(),coffeeUpdateEvent);

        var recordMetadata = producer.send(producerRecord).get();
        log.info("recordMetadata : {}",recordMetadata);
        log.info("published the producerRecird : {}",producerRecord);

    }

    private static CoffeeUpdateEvent buildCoffeeUpdateEvent() {
        return CoffeeUpdateEvent.newBuilder()
                .setId(UUID.fromString("c9df0823-2bbd-419e-ab60-535c0420c127"))
                .setStatus(OrderStatus.PROCESSING)
                .build();
    }
}
