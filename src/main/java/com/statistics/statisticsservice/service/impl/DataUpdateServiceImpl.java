package com.statistics.statisticsservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.statistics.statisticsservice.dto.StatisticsDto;
import com.statistics.statisticsservice.model.ReportSpecification;
import com.statistics.statisticsservice.model.SalesAndTrafficByAsin;
import com.statistics.statisticsservice.model.SalesAndTrafficByDate;
import com.statistics.statisticsservice.repository.ReportSpecificationRepository;
import com.statistics.statisticsservice.repository.SalesAndTrafficByAsinRepository;
import com.statistics.statisticsservice.repository.SalesAndTrafficByDateRepository;
import com.statistics.statisticsservice.service.DataUpdateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class DataUpdateServiceImpl implements DataUpdateService {


    private final ObjectMapper objectMapper;


    private final ResourceLoader resourceLoader;

    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;

    private final ReportSpecificationRepository reportSpecificationRepository;

    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;


    @Scheduled(fixedRate = 60000)
    public void fetchDataAndUpdateDb() {
        try {
            log.info("Fetching data from the file and updating the database...");
            // Load JSON file from resources
            var resource = resourceLoader.getResource("classpath:public/report_json_full.json");
            try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
                String json = FileCopyUtils.copyToString(reader);

                StatisticsDto statistic = objectMapper.readValue(json, StatisticsDto.class);

                ReportSpecification reportSpecification = statistic.reportSpecification();
                reportSpecificationRepository.findByReportType(reportSpecification.getReportType())
                        .ifPresentOrElse(
                                r -> {
                                    if (!r.equals(reportSpecification)) {
                                        reportSpecification.setId(r.getId());
                                        reportSpecificationRepository.save(reportSpecification);
                                    }
                                },
                                () -> reportSpecificationRepository.save(reportSpecification)
                        );

                List<SalesAndTrafficByAsin> salesAndTrafficByAsin = statistic.salesAndTrafficByAsin();
                for (SalesAndTrafficByAsin sale : salesAndTrafficByAsin) {
                    salesAndTrafficByAsinRepository.findByParentAsin(sale.getParentAsin())
                            .ifPresentOrElse(
                                    document -> {
                                        if (!document.equals(sale)) {
                                            sale.setId(document.getId());
                                            salesAndTrafficByAsinRepository.save(sale);
                                        }
                                    },
                                    () -> salesAndTrafficByAsinRepository.save(sale)
                            );

                }

                List<SalesAndTrafficByDate> salesAndTrafficByDates = statistic.salesAndTrafficByDate();
                for (SalesAndTrafficByDate sale : salesAndTrafficByDates) {
                    salesAndTrafficByDateRepository.findByDate(sale.getDate())
                            .ifPresentOrElse(
                                    document -> {
                                        if (!document.equals(sale)) {
                                            sale.setId(document.getId());
                                            salesAndTrafficByDateRepository.save(sale);
                                        }
                                    },
                                    () -> salesAndTrafficByDateRepository.save(sale)
                            );
                }
                log.info("Data updated successfully.");
            }
        } catch (IOException e) {
            log.error("Error reading or processing the JSON file.");
        }
    }

}
