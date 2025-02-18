package com.customerjourneyevent.repository;

import com.customerjourneyevent.entity.CustomerJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerJourneyRepository extends JpaRepository<CustomerJourney, Long> {

    @Query(" SELECT cj FROM CustomerJourney cj WHERE cj.customerId=:customerId ")
    List<CustomerJourney> findByCustomerIdOrderByTimestampAsc(@Param("customerId") String customerId);
}
