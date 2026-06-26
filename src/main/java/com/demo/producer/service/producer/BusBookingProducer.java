package com.demo.producer.service.producer;

import com.demo.producer.dto.BookingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class BusBookingProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusBookingProducer.class);

    private KafkaTemplate<String, BookingEvent> kafkaTemplate;

    public BusBookingProducer(KafkaTemplate<String, BookingEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(BookingEvent event) {
        LOGGER.info(String.format("Message sent -> %s", event.toString()));

        Message<BookingEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "bus_booking_event")
                .build();

        kafkaTemplate.send(message);
    }
}
