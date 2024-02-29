package com.statistics.statisticsservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "salesAndTrafficByAsin")
@Getter
@Setter
public class SalesAndTrafficByAsin {
    @Id
    private String id;
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesAndTrafficByAsin that = (SalesAndTrafficByAsin) o;
        return Objects.equals(parentAsin, that.parentAsin) && Objects.equals(salesByAsin, that.salesByAsin)
                && Objects.equals(trafficByAsin, that.trafficByAsin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentAsin, salesByAsin, trafficByAsin);
    }
}
