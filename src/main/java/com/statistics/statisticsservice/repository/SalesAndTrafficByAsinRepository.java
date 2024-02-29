package com.statistics.statisticsservice.repository;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.model.SalesAndTrafficByAsin;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesAndTrafficByAsinRepository extends MongoRepository<SalesAndTrafficByAsin, String> {

    Optional<SalesAndTrafficByAsin> findByParentAsin(String parentAsin);

    List<SalesAndTrafficByAsin> findByParentAsinIn(List<String> parentAsin);

    @Aggregation(pipeline = {
            "{ '$group': { " +
                    "'_id': null, " +
                    "'totalOrderedProductSales': { '$sum': '$salesByDate.orderedProductSales.amount' }, " +
                    "'totalOrderedProductSalesB2B': { '$sum': '$salesByDate.orderedProductSalesB2B.amount' } " +
                    "} }"
    })
    AggregateResult findTotalSales();


}