package com.statistics.statisticsservice.mapper;

import com.statistics.statisticsservice.dto.UserReqRespDto;
import com.statistics.statisticsservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper extends EntityMapper<UserReqRespDto, User> {

    //ignore password
    @Mapping(target = "password", ignore = true)
    UserReqRespDto toDto(User dto);


}
