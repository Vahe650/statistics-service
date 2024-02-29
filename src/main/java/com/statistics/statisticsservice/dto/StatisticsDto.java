package com.statistics.statisticsservice.dto;

import com.statistics.statisticsservice.model.ReportSpecification;
import com.statistics.statisticsservice.model.SalesAndTrafficByAsin;
import com.statistics.statisticsservice.model.SalesAndTrafficByDate;

import java.util.List;


public record StatisticsDto(
        ReportSpecification reportSpecification,
        List<SalesAndTrafficByDate> salesAndTrafficByDate,
        List<SalesAndTrafficByAsin> salesAndTrafficByAsin

) {
}
