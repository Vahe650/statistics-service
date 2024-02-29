package com.statistics.statisticsservice.dto;

import com.statistics.statisticsservice.model.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(fluent = true, chain = true)
@Getter
@Setter
public class UserJwtResponseDto {
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}
