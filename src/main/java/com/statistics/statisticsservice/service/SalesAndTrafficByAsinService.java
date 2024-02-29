package com.statistics.statisticsservice.service;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.dto.SalesAndTrafficByAsinDto;

import java.util.List;


public interface SalesAndTrafficByAsinService {

    /**
     * Find sales and traffic by asin
     *
     * @param parentAsin parent asin
     * @return SalesAndTrafficByAsinDto
     */
    SalesAndTrafficByAsinDto findByParentAsin(String parentAsin);

    /**
     * Find sales and traffic by asin
     *
     * @param parentAsins parent asins
     * @return List of SalesAndTrafficByAsinDto
     */
    List<SalesAndTrafficByAsinDto> findByParentAsins(List<String> parentAsins);

    /**
     * Get summary statistics
     *
     * @return AggregateResult
     */
    AggregateResult getSummaryStatistics();
}
