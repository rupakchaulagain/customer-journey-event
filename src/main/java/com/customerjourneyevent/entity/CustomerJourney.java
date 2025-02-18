package com.customerjourneyevent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_journey")
@Getter
@Setter
public class CustomerJourney {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String customerId;
    
    @Column(nullable = false)
    private String stage;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;


    public CustomerJourney() {}

    public CustomerJourney(String customerId, String stage) {
        this.customerId = customerId;
        this.stage = stage;
        this.timestamp = LocalDateTime.now();
    }

}
