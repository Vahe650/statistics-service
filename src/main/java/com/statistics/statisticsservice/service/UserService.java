package com.statistics.statisticsservice.service;

import com.statistics.statisticsservice.dto.UserReqRespDto;

public interface UserService {

    /**
     * Login
     *
     * @param credentialsDto credentials
     * @return UserReqRespDto
     */
    UserReqRespDto login(UserReqRespDto credentialsDto);

    /**
     * Register
     *
     * @param userReqRespDto user
     * @return UserReqRespDto
     */
    UserReqRespDto register(UserReqRespDto userReqRespDto);


}
