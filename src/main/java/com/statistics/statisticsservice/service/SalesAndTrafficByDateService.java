package com.statistics.statisticsservice.service;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.dto.SalesAndTrafficByDateDto;

import java.time.LocalDate;
import java.util.List;


public interface SalesAndTrafficByDateService {

    /**
     * Find sales and traffic by date
     *
     * @param date date
     * @return SalesAndTrafficByDateDto
     */
    SalesAndTrafficByDateDto findByDate(LocalDate date);

    /**
     * Find sales and traffic by date between
     *
     * @param startDate start date
     * @param endDate   end date
     * @return List of SalesAndTrafficByDateDto
     */
    List<SalesAndTrafficByDateDto> findByDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Get summary statistics
     *
     * @return AggregateResult
     */
    AggregateResult getSummaryStatistics();


}
