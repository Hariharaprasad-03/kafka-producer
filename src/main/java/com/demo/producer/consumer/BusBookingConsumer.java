package com.demo.producer.consumer;

import com.demo.producer.dto.BookingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BusBookingConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusBookingConsumer.class);

    @KafkaListener(topics = "bus_booking_event", groupId = "myGroup")
    public void consume(BookingEvent event) {
        LOGGER.info(String.format("Message received -> %s", event.toString()));
    }
}
