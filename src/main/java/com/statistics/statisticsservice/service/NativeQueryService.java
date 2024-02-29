package com.statistics.statisticsservice.service;

import com.statistics.statisticsservice.dto.AggregateResult;

public interface NativeQueryService {

    /**
     * Find total sales.
     *
     * @return the aggregate result
     */
    AggregateResult findTotalSalesByDate();

    /**
     * Find total sales by asin.
     *
     * @return the aggregate result
     */
    AggregateResult findTotalSalesByAsin();

}
