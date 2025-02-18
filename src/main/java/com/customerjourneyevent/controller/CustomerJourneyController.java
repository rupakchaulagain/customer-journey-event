package com.customerjourneyevent.controller;

import com.customerjourneyevent.entity.CustomerJourney;
import com.customerjourneyevent.service.CustomerJourneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journey")
@RequiredArgsConstructor
public class CustomerJourneyController {
    private final CustomerJourneyService customerJourneyService;

    @PostMapping("/start/{customerId}")
    public String startJourney(@PathVariable String customerId) {
        customerJourneyService.startJourney(customerId);
        return "Customer journey started for " + customerId;
    }

    @PostMapping("/complete/{customerId}")
    public String completeJourney(@PathVariable String customerId) {
        customerJourneyService.completeJourney(customerId);
        return "Customer journey completed for " + customerId;
    }

    @GetMapping("/{customerId}")
    public List<CustomerJourney> getJourney(@PathVariable String customerId) {
        return customerJourneyService.getCustomerJourney(customerId);
    }
}
