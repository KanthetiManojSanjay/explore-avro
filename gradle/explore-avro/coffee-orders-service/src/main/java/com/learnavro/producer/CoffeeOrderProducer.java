package com.learnavro.producer;

import com.learnavro.domain.generated.CoffeeOrder;
import com.learnavro.util.CoffeeOrderUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author kansanja on 07/01/23.
 */
public class CoffeeOrderProducer {
    private static final String COFFEE_ORDERS = "coffee-orders";
    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderProducer.class);

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName());

        KafkaProducer<String, byte[]> producer = new KafkaProducer<String, byte[]>(properties);

        CoffeeOrder coffeeOrder = CoffeeOrderUtil.buildNewCoffeeOrder();

        byte[] value = coffeeOrder.toByteBuffer().array();

        ProducerRecord<String, byte[]> producerRecord = new ProducerRecord<>(COFFEE_ORDERS, value);

        var recordMetadata = producer.send(producerRecord).get();
        log.info("recordMetadata : {}",recordMetadata);

    }
}
