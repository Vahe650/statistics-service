package com.statistics.statisticsservice.controller;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.dto.SalesAndTrafficByDateDto;
import com.statistics.statisticsservice.service.SalesAndTrafficByDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales-and-traffic-by-date")
public class SalesAndTrafficByDateController {


    private final SalesAndTrafficByDateService salesAndTrafficByDateService;

    @GetMapping("/range")
    public List<SalesAndTrafficByDateDto> findByDateBetween(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return salesAndTrafficByDateService.findByDateBetween(startDate, endDate);
    }

    @GetMapping("/date")
    public SalesAndTrafficByDateDto getSalesAndTrafficByDate(@RequestParam LocalDate date) {
        return salesAndTrafficByDateService.findByDate(date);
    }

    @GetMapping("/summary")
    public AggregateResult getSummaryStatistics() {
        return salesAndTrafficByDateService.getSummaryStatistics();
    }

}
