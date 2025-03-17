package com.customerjourneyevent.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerJourneyEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public void publishEvent(String customerId, String journeyStage) {
        CustomerJourneyEvent event = new CustomerJourneyEvent(this, customerId, journeyStage);
        eventPublisher.publishEvent(event);
    }
}
