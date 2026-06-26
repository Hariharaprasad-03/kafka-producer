package com.demo.producer.service;

import com.demo.producer.dto.BookingEvent;
import com.demo.producer.service.producer.BusBookingProducer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BusBookingService {

    private final BusBookingProducer busBookingProducer;

    public BusBookingService(BusBookingProducer busBookingProducer) {
        this.busBookingProducer = busBookingProducer;
    }

    public void generateBookingEvent() {
        BookingEvent bookingEvent = new BookingEvent(UUID.randomUUID().toString(), "New bus booking event!");
        busBookingProducer.sendMessage(bookingEvent);
    }
}
