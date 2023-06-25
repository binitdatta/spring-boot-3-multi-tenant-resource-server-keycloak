package com.rollingstone.listeners;

import com.rollingstone.events.CustomerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventListener {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void onApplicationEvent(CustomerEvent customerEvent) {
        log.info("Received Customer Event : "+customerEvent.getEventType());
        log.info("Received Customer From Customer Event :"+customerEvent.getCustomer().toString());
    }
}