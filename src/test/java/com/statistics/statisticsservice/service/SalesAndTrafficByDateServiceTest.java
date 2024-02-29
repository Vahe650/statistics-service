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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SalesAndTrafficByDateServiceTest {

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
        SalesAndTrafficByDateDto expectedDto = new SalesAndTrafficByDateDto("test", LocalDate.now(), new SalesByDate(), new TrafficByDate());
        when(salesAndTrafficByDateRepository.findByDate(date)).thenReturn(Optional.of(new SalesAndTrafficByDate()));
        when(salesAndTrafficByDateMapper.toDto((SalesAndTrafficByDate) any())).thenReturn(expectedDto);

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
        SalesAndTrafficByDateDto salesAndTrafficByDateDto1 = new SalesAndTrafficByDateDto("test1", LocalDate.now(), new SalesByDate(), new TrafficByDate());
        SalesAndTrafficByDateDto salesAndTrafficByDateDto2 = new SalesAndTrafficByDateDto("test2", LocalDate.now(), new SalesByDate(), new TrafficByDate());

        List<SalesAndTrafficByDateDto> expectedDtos = Arrays.asList(salesAndTrafficByDateDto1, salesAndTrafficByDateDto2);
        when(salesAndTrafficByDateRepository.findByDateBetween(startDate, endDate)).thenReturn(Arrays.asList(new SalesAndTrafficByDate(), new SalesAndTrafficByDate()));
        when(salesAndTrafficByDateMapper.toDto(anyList())).thenReturn(expectedDtos);

        List<SalesAndTrafficByDateDto> result = service.findByDateBetween(startDate, endDate);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        verify(salesAndTrafficByDateRepository).findByDateBetween(startDate, endDate);
        verify(salesAndTrafficByDateMapper).toDto(anyList());
    }

    @Test
    void getSummaryStatisticsSuccess() {
        AggregateResult expectedAggregateResult = new AggregateResult(50d, 90d);
        when(nativeQueryService.findTotalSalesByDate()).thenReturn(expectedAggregateResult);

        AggregateResult result = service.getSummaryStatistics();

        assertEquals(result.totalOrderedProductSales(), 50d);
        assertEquals(result.totalOrderedProductSalesB2B(), 90d);
        verify(nativeQueryService).findTotalSalesByDate();
    }
}
