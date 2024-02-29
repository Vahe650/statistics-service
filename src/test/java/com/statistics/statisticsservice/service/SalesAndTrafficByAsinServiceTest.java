package com.statistics.statisticsservice.service;

import com.statistics.statisticsservice.dto.AggregateResult;
import com.statistics.statisticsservice.dto.SalesAndTrafficByDateDto;
import com.statistics.statisticsservice.hander.exception.EntityNotFoundException;
import com.statistics.statisticsservice.mapper.SalesAndTrafficByDateMapper;
import com.statistics.statisticsservice.model.SalesAndTrafficByDate;
import com.statistics.statisticsservice.model.SalesByDate;
import com.statistics.statisticsservice.model.TrafficByDate;
import com.statistics.statisticsservice.repository.SalesAndTrafficByDateRepository;
import com.statistics.statisticsservice.service.impl.SalesAndTrafficByDateServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class SalesAndTrafficByAsinServiceTest {

    @Mock
    private SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;

    @Mock
    private SalesAndTrafficByDateMapper salesAndTrafficByDateMapper;

    @Mock
    private NativeQueryService nativeQueryService;

    @InjectMocks
    private SalesAndTrafficByDateServiceImpl service;

    @Test
    void findByDateSuccess() {
        LocalDate date = LocalDate.now();
        when(salesAndTrafficByDateRepository.findByDate(date)).thenReturn(Optional.of(new SalesAndTrafficByDate()));
        when(salesAndTrafficByDateMapper.toDto((SalesAndTrafficByDate) any()))
                .thenReturn(new SalesAndTrafficByDateDto("test", LocalDate.now(), new SalesByDate(), new TrafficByDate()));

        SalesAndTrafficByDateDto result = service.findByDate(date);

        assertNotNull(result);
        verify(salesAndTrafficByDateRepository).findByDate(date);
        verify(salesAndTrafficByDateMapper).toDto((SalesAndTrafficByDate) any());
    }

    @Test
    void findByDateNotFound() {
        LocalDate date = LocalDate.now();
        when(salesAndTrafficByDateRepository.findByDate(date)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.findByDate(date));
    }

    @Test
    void findByDateBetweenSuccess() {
        LocalDate startDate = LocalDate.now().minusDays(5);
        LocalDate endDate = LocalDate.now();
        when(salesAndTrafficByDateRepository.findByDateBetween(startDate, endDate)).thenReturn(Collections.emptyList());
        when(salesAndTrafficByDateMapper.toDto(anyList())).thenReturn(Collections.emptyList());

        List<SalesAndTrafficByDateDto> result = service.findByDateBetween(startDate, endDate);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(salesAndTrafficByDateRepository).findByDateBetween(startDate, endDate);
        verify(salesAndTrafficByDateMapper).toDto(anyList());
    }

    @Test
    void getSummaryStatisticsSuccess() {
        when(nativeQueryService.findTotalSalesByDate()).thenReturn(new AggregateResult(40d, 60d));

        AggregateResult result = service.getSummaryStatistics();

        assertEquals(result.totalOrderedProductSales(), 40d);
        assertEquals(result.totalOrderedProductSalesB2B(), 60d);
        verify(nativeQueryService).findTotalSalesByDate();
    }
}
