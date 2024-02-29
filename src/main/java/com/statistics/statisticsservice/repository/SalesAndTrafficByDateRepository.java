package com.statistics.statisticsservice.repository;

import com.statistics.statisticsservice.model.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SalesAndTrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {


    Optional<SalesAndTrafficByDate> findByDate(LocalDate date);


    List<SalesAndTrafficByDate> findByDateBetween(LocalDate startDate, LocalDate endDate);


}