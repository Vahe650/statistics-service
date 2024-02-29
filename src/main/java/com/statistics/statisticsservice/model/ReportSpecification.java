package com.statistics.statisticsservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Document(collection = "reportSpecifications")
@Getter
@Setter
public class ReportSpecification {
    @Id
    private String id;
    private String reportType;
    private Map<String, String> reportOptions;
    private String dataStartTime;
    private String dataEndTime;
    private List<String> marketplaceIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportSpecification that = (ReportSpecification) o;
        return Objects.equals(reportType, that.reportType) && Objects.equals(reportOptions, that.reportOptions) && Objects.equals(dataStartTime, that.dataStartTime) && Objects.equals(dataEndTime, that.dataEndTime) && Objects.equals(marketplaceIds, that.marketplaceIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportType, reportOptions, dataStartTime, dataEndTime, marketplaceIds);
    }
}
