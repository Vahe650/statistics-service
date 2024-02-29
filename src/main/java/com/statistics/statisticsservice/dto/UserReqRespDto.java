package com.statistics.statisticsservice.dto;

import com.statistics.statisticsservice.model.Role;
import lombok.Builder;

@Builder
public record UserReqRespDto(
        String id,
        String email,
        String password,
        Role role

) {
}
