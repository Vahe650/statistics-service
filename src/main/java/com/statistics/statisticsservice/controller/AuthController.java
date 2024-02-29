package com.statistics.statisticsservice.controller;

import com.statistics.statisticsservice.config.UserAuthProvider;
import com.statistics.statisticsservice.dto.UserReqRespDto;
import com.statistics.statisticsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public String login(
            @RequestBody UserReqRespDto userReqRespDto
    ) {
        UserReqRespDto dto = userService.login(userReqRespDto);

        return userAuthProvider.createToken(dto);
    }

    @PostMapping("/register")
    public UserReqRespDto register(
            @RequestBody UserReqRespDto userReqRespDto
    ) {
        return userService.register(userReqRespDto);
    }

}
