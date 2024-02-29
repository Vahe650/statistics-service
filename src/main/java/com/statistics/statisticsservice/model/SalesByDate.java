package com.statistics.statisticsservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class SalesByDate {
    private Map<String, Object> orderedProductSales;
    private Map<String, Object> orderedProductSalesB2B;
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;
    private Map<String, Object> averageSalesPerOrderItem;
    private Map<String, Object> averageSalesPerOrderItemB2B;
    private Double averageUnitsPerOrderItem;
    private Double averageUnitsPerOrderItemB2B;
    private Map<String, Object> averageSellingPrice;
    private Map<String, Object> averageSellingPriceB2B;
    private Integer unitsRefunded;
    private Double refundRate;
    private Integer claimsGranted;
    private Map<String, Object> claimsAmount;
    private Map<String, Object> shippedProductSales;
    private Integer unitsShipped;
    private Integer ordersShipped;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesByDate that = (SalesByDate) o;
        return Objects.equals(orderedProductSales, that.orderedProductSales)
                && Objects.equals(orderedProductSalesB2B, that.orderedProductSalesB2B)
                && Objects.equals(unitsOrdered, that.unitsOrdered)
                && Objects.equals(unitsOrderedB2B, that.unitsOrderedB2B)
                && Objects.equals(totalOrderItems, that.totalOrderItems)
                && Objects.equals(totalOrderItemsB2B, that.totalOrderItemsB2B)
                && Objects.equals(averageSalesPerOrderItem, that.averageSalesPerOrderItem)
                && Objects.equals(averageSalesPerOrderItemB2B, that.averageSalesPerOrderItemB2B)
                && Objects.equals(averageUnitsPerOrderItem, that.averageUnitsPerOrderItem)
                && Objects.equals(averageUnitsPerOrderItemB2B, that.averageUnitsPerOrderItemB2B)
                && Objects.equals(averageSellingPrice, that.averageSellingPrice)
                && Objects.equals(averageSellingPriceB2B, that.averageSellingPriceB2B)
                && Objects.equals(unitsRefunded, that.unitsRefunded) && Objects.equals(refundRate, that.refundRate)
                && Objects.equals(claimsGranted, that.claimsGranted) && Objects.equals(claimsAmount, that.claimsAmount)
                && Objects.equals(shippedProductSales, that.shippedProductSales) && Objects.equals(unitsShipped, that.unitsShipped)
                && Objects.equals(ordersShipped, that.ordersShipped);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedProductSales, orderedProductSalesB2B, unitsOrdered, unitsOrderedB2B, totalOrderItems,
                totalOrderItemsB2B, averageSalesPerOrderItem, averageSalesPerOrderItemB2B, averageUnitsPerOrderItem,
                averageUnitsPerOrderItemB2B, averageSellingPrice, averageSellingPriceB2B, unitsRefunded, refundRate,
                claimsGranted, claimsAmount, shippedProductSales, unitsShipped, ordersShipped);
    }
}
