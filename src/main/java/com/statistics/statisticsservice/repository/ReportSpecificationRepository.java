package com.statistics.statisticsservice.repository;

import com.statistics.statisticsservice.model.ReportSpecification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportSpecificationRepository extends MongoRepository<ReportSpecification, String> {

    Optional<ReportSpecification> findByReportType(String reportType);


}