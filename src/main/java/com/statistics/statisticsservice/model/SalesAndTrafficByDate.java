package com.statistics.statisticsservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document(collection = "salesAndTrafficByDate")
@Getter
@Setter
public class SalesAndTrafficByDate {
    @Id
    private String id;
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesAndTrafficByDate that = (SalesAndTrafficByDate) o;
        return Objects.equals(date, that.date) && Objects.equals(salesByDate, that.salesByDate) && Objects.equals(trafficByDate, that.trafficByDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, salesByDate, trafficByDate);
    }
}
