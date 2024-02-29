package com.statistics.statisticsservice.service.impl;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.dto.SalesAndTrafficByAsinDto;
import com.statistics.statisticsservice.hander.exception.EntityNotFoundException;
import com.statistics.statisticsservice.mapper.SalesAndTrafficByAsinMapper;
import com.statistics.statisticsservice.repository.SalesAndTrafficByAsinRepository;
import com.statistics.statisticsservice.service.NativeQueryService;
import com.statistics.statisticsservice.service.SalesAndTrafficByAsinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SalesAndTrafficByAsinServiceImpl implements SalesAndTrafficByAsinService {

    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;
    private final SalesAndTrafficByAsinMapper salesAndTrafficByAsinMapper;
    private final NativeQueryService nativeQueryService;

    @Override
    public SalesAndTrafficByAsinDto findByParentAsin(String parentAsin) {
        log.info("Fetching sales and traffic by date for parentAsin: {}", parentAsin);
         return salesAndTrafficByAsinRepository.findByParentAsin(parentAsin)
                .map(salesAndTrafficByAsinMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("Sales and traffic by asin not found"));

    }

    @Override
    public List<SalesAndTrafficByAsinDto> findByParentAsins(List<String> parentAsins) {
        log.info("Fetching sales and traffic by date for parentAsins: {}", parentAsins);
        return salesAndTrafficByAsinMapper.toDto(salesAndTrafficByAsinRepository.findByParentAsinIn(parentAsins));
    }

    @Override
    public AggregateResult getSummaryStatistics() {
        log.info("Fetching summary statistics for all ASINs");
        return nativeQueryService.findTotalSalesByAsin();
    }


}