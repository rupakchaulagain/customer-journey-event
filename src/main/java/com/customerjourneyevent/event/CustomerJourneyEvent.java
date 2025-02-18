package com.customerjourneyevent.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CustomerJourneyEvent extends ApplicationEvent {
    private final String customerId;
    private final String journeyStage;

    public CustomerJourneyEvent(Object source, String customerId, String journeyStage) {
        super(source);
        this.customerId = customerId;
        this.journeyStage = journeyStage;
    }
}
