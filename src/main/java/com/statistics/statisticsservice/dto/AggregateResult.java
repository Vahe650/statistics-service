package com.statistics.statisticsservice.dto;

public record AggregateResult(
        Double totalOrderedProductSales,
        Double totalOrderedProductSalesB2B
) {
}
