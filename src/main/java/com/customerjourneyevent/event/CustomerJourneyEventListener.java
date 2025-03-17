package com.customerjourneyevent.event;

import com.customerjourneyevent.entity.CustomerJourney;
import com.customerjourneyevent.repository.CustomerJourneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerJourneyEventListener {

    private final CustomerJourneyRepository journeyRepository;

    @EventListener
    public void handleCustomerJourneyEvent(CustomerJourneyEvent event) {
        System.out.println("Saving journey step: " + event.getJourneyStage() + " for Customer ID: " + event.getCustomerId());

        CustomerJourney journey = new CustomerJourney(event.getCustomerId(), event.getJourneyStage());
        journeyRepository.save(journey); // Save event to the database
    }
}
