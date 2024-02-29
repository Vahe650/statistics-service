package com.statistics.statisticsservice.controller;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.dto.SalesAndTrafficByAsinDto;
import com.statistics.statisticsservice.service.SalesAndTrafficByAsinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales-and-traffic-by-asin")
public class SalesAndTrafficByAsinController {


    private final SalesAndTrafficByAsinService andTrafficByAsinService;


    @GetMapping("/asin")
    public SalesAndTrafficByAsinDto getSalesAndTrafficByAsin(@RequestParam String parentAsin) {
        return andTrafficByAsinService.findByParentAsin(parentAsin);
    }

    @GetMapping("/asins")
    public List<SalesAndTrafficByAsinDto> getSalesAndTrafficByAsin(@RequestParam List<String> parentAsins) {
        return andTrafficByAsinService.findByParentAsins(parentAsins);
    }

    @GetMapping("/summary")
    public AggregateResult getSummaryStatistics() {
        return andTrafficByAsinService.getSummaryStatistics();
    }

}
