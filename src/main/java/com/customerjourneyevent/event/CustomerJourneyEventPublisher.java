package com.customerjourneyevent.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomerJourneyEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public CustomerJourneyEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishEvent(String customerId, String journeyStage) {
        CustomerJourneyEvent event = new CustomerJourneyEvent(this, customerId, journeyStage);
        eventPublisher.publishEvent(event);
    }
}
