package com.customerjourneyevent.event;

import com.customerjourneyevent.entity.CustomerJourney;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.customerjourneyevent.repository.CustomerJourneyRepository;

@Component
public class CustomerJourneyEventListener {

    private final CustomerJourneyRepository journeyRepository;

    public CustomerJourneyEventListener(CustomerJourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    @EventListener
    public void handleCustomerJourneyEvent(CustomerJourneyEvent event) {
        System.out.println("Saving journey step: " + event.getJourneyStage() + " for Customer ID: " + event.getCustomerId());

        CustomerJourney journey = new CustomerJourney(event.getCustomerId(), event.getJourneyStage());
        journeyRepository.save(journey); // Save event to the database
    }
}
