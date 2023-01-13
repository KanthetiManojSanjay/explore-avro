package com.learnavro.producer;

import com.learnavro.domain.generated.CoffeeOrder;
import com.learnavro.domain.generated.OrderId;
import com.learnavro.util.CoffeeOrderUtil;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author kansanja on 07/01/23.
 */
public class CoffeeOrderProducerSchemaRegistry {
    private static final String COFFEE_ORDERS = "coffee-orders-sr";
    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderProducerSchemaRegistry.class);

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        KafkaProducer<String, CoffeeOrder> producer = new KafkaProducer<String, CoffeeOrder>(properties);

        CoffeeOrder coffeeOrder = CoffeeOrderUtil.buildNewCoffeeOrder();

        ProducerRecord<String, CoffeeOrder> producerRecord = new ProducerRecord<>(COFFEE_ORDERS, coffeeOrder.getId().toString(),coffeeOrder);

        var recordMetadata = producer.send(producerRecord).get();
        log.info("recordMetadata : {}",recordMetadata);
        log.info("published the producerRecird : {}",producerRecord);

    }
}
