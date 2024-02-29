package com.statistics.statisticsservice.dto;

import com.statistics.statisticsservice.model.SalesByDate;
import com.statistics.statisticsservice.model.TrafficByDate;

import java.time.LocalDate;


public record SalesAndTrafficByDateDto(
        String id,
        LocalDate date,
        SalesByDate salesByDate,
        TrafficByDate trafficByDate
) {
}
