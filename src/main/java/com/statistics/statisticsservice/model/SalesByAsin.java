package com.statistics.statisticsservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class SalesByAsin {
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private Map<String, Object> orderedProductSales;
    private Map<String, Object> orderedProductSalesB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesByAsin that = (SalesByAsin) o;
        return Objects.equals(unitsOrdered, that.unitsOrdered) && Objects.equals(unitsOrderedB2B, that.unitsOrderedB2B)
                && Objects.equals(orderedProductSales, that.orderedProductSales)
                && Objects.equals(orderedProductSalesB2B, that.orderedProductSalesB2B)
                && Objects.equals(totalOrderItems, that.totalOrderItems)
                && Objects.equals(totalOrderItemsB2B, that.totalOrderItemsB2B);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitsOrdered, unitsOrderedB2B, orderedProductSales,
                orderedProductSalesB2B, totalOrderItems,
                totalOrderItemsB2B);
    }
}
