package com.learnavro.consumer;

import com.learnavro.Greeting;
import com.learnavro.producer.GreetingProducer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author kansanja on 05/01/23.
 */
public class GreetingConsumer {
    private static final String GREETING_TOPIC = "greeting";
    private static final Logger log = LoggerFactory.getLogger(GreetingProducer.class);

    public static void main(String[] args){

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG , "greeting.consumer");

        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(GREETING_TOPIC));
        log.info("Consumer started");
        while (true){
            ConsumerRecords<String, byte[]> records = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String, byte[]> record : records){
                Greeting greeting = null;
                try {
                    greeting = decodeAvroGreeting(record.value());
                    log.info("Consumed Message , key : {} , value : {}", record.key() , greeting.toString());
                } catch (IOException e) {
                   log.error("Exception is : {}", e.getMessage() , e);
                }

            }
        }
    }

    private static Greeting decodeAvroGreeting(byte[] array) throws IOException {
        return Greeting.fromByteBuffer(ByteBuffer.wrap(array));
    }


}
