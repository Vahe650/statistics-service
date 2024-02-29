package com.statistics.statisticsservice.dto;

import com.statistics.statisticsservice.model.SalesByAsin;
import com.statistics.statisticsservice.model.TrafficByAsin;


public record SalesAndTrafficByAsinDto(
        String id,
        String parentAsin,
        SalesByAsin salesByAsin,
        TrafficByAsin trafficByAsin
) {
}
