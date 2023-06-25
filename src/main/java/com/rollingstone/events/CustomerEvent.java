package com.rollingstone.events;

import com.rollingstone.model.Customer;
import org.springframework.context.ApplicationEvent;

public class CustomerEvent extends ApplicationEvent {
    private String eventType;
    private Customer customer;
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public CustomerEvent(Object source, String eventType, Customer customer) {
        super(source);
        this.eventType = eventType;
        this.customer = customer;
    }
    @Override
    public String toString() {
        return "WaveEvent [eventType=" + eventType + ", customer=" + customer + "]";
    }


}