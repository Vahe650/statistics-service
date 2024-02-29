package com.statistics.statisticsservice.mapper;

import com.statistics.statisticsservice.dto.SalesAndTrafficByAsinDto;
import com.statistics.statisticsservice.model.SalesAndTrafficByAsin;
import org.mapstruct.Mapper;

@Mapper
public interface SalesAndTrafficByAsinMapper extends EntityMapper<SalesAndTrafficByAsinDto, SalesAndTrafficByAsin> {

}
