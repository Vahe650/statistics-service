package com.statistics.statisticsservice.service.impl;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.dto.SalesAndTrafficByDateDto;
import com.statistics.statisticsservice.hander.exception.EntityNotFoundException;
import com.statistics.statisticsservice.mapper.SalesAndTrafficByDateMapper;
import com.statistics.statisticsservice.repository.SalesAndTrafficByDateRepository;
import com.statistics.statisticsservice.service.NativeQueryService;
import com.statistics.statisticsservice.service.SalesAndTrafficByDateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SalesAndTrafficByDateServiceImpl implements SalesAndTrafficByDateService {

    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;

    private final SalesAndTrafficByDateMapper salesAndTrafficByDateMapper;

    private final NativeQueryService nativeQueryService;

    @Override
    public SalesAndTrafficByDateDto findByDate(LocalDate date) {
        return salesAndTrafficByDateRepository.findByDate(date)
                .map(salesAndTrafficByDateMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Sales and traffic by date not found"));
    }

    @Override
    public List<SalesAndTrafficByDateDto> findByDateBetween(LocalDate startDate, LocalDate endDate) {
        return salesAndTrafficByDateMapper.toDto(salesAndTrafficByDateRepository.findByDateBetween(startDate, endDate));
    }

    @Override
    public AggregateResult getSummaryStatistics() {
        log.info("Fetching summary statistics for all dates");
        return nativeQueryService.findTotalSalesByDate();
    }

}