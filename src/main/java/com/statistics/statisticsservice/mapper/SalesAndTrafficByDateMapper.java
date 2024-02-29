package com.statistics.statisticsservice.mapper;

import com.statistics.statisticsservice.dto.SalesAndTrafficByDateDto;
import com.statistics.statisticsservice.model.SalesAndTrafficByDate;
import org.mapstruct.Mapper;

@Mapper
public interface SalesAndTrafficByDateMapper extends EntityMapper<SalesAndTrafficByDateDto, SalesAndTrafficByDate> {

}
