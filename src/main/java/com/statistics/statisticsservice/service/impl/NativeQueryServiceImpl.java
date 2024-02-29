package com.statistics.statisticsservice.service.impl;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.model.SalesAndTrafficByAsin;
import com.statistics.statisticsservice.model.SalesAndTrafficByDate;
import com.statistics.statisticsservice.service.NativeQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NativeQueryServiceImpl implements NativeQueryService {

    private final MongoTemplate mongoTemplate;

    public AggregateResult findTotalSalesByDate() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group()
                        .sum("salesByDate.orderedProductSales.amount").as("totalOrderedProductSales")
                        .sum("salesByDate.orderedProductSalesB2B.amount").as("totalOrderedProductSalesB2B")
        );

        AggregationResults<AggregateResult> results = mongoTemplate.aggregate(aggregation, SalesAndTrafficByDate.class, AggregateResult.class);
        if (!results.getMappedResults().isEmpty()) {
            return results.getMappedResults().stream().findFirst().orElse(null);
        }
        return null;
    }

    public AggregateResult findTotalSalesByAsin() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group()
                        .sum("salesByAsin.orderedProductSales.amount").as("totalOrderedProductSales")
                        .sum("salesByAsin.orderedProductSalesB2B.amount").as("totalOrderedProductSalesB2B")
        );

        AggregationResults<AggregateResult> results = mongoTemplate.aggregate(aggregation, SalesAndTrafficByAsin.class, AggregateResult.class);
        if (!results.getMappedResults().isEmpty()) {
            return results.getMappedResults().stream().findFirst().orElse(null);
        }
        return null;
    }

}