package com.customerjourneyevent.service;

import com.customerjourneyevent.entity.CustomerJourney;
import com.customerjourneyevent.event.CustomerJourneyEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.customerjourneyevent.repository.CustomerJourneyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerJourneyService {
    private final CustomerJourneyEventPublisher eventPublisher;
    private final CustomerJourneyRepository customerJourneyRepository;

    public void startJourney(String customerId) {
        System.out.println("Starting journey for Customer: " + customerId);
        eventPublisher.publishEvent(customerId, "Started");
    }

    public void completeJourney(String customerId) {
        System.out.println("Completing journey for Customer: " + customerId);
        eventPublisher.publishEvent(customerId, "Completed");
    }

    public List<CustomerJourney> getCustomerJourney(String customerId) {
        return customerJourneyRepository.findByCustomerIdOrderByTimestampAsc(customerId);
    }
}
