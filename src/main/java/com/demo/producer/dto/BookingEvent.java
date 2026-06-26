package com.demo.producer.dto;

public class BookingEvent {
    private String eventId;
    private String message;

    public BookingEvent() {
    }

    public BookingEvent(String eventId, String message) {
        this.eventId = eventId;
        this.message = message;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BookingEvent{" +
                "eventId='" + eventId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
