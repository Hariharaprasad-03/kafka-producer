package com.demo.producer.controller;

import com.demo.producer.service.BusBookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bus-booking")
public class BusBookingController {

    private final BusBookingService busBookingService;

    public BusBookingController(BusBookingService busBookingService) {
        this.busBookingService = busBookingService;
    }

    @PostMapping("/book")
    public String book() {
        busBookingService.generateBookingEvent();
        return "Booking event generated";
    }
}
