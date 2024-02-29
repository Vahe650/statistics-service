package com.statistics.statisticsservice.service.impl;

import com.statistics.statisticsservice.dto.UserReqRespDto;
import com.statistics.statisticsservice.hander.exception.AuthorizeException;
import com.statistics.statisticsservice.hander.exception.EntityExistException;
import com.statistics.statisticsservice.mapper.UserMapper;
import com.statistics.statisticsservice.model.Role;
import com.statistics.statisticsservice.model.User;
import com.statistics.statisticsservice.repository.UserRepository;
import com.statistics.statisticsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserReqRespDto register(UserReqRespDto dto) {
        log.info("Registering user with email: {}", dto.email());
        Optional<User> oUser = userRepository.findByEmail(dto.email());

        oUser.ifPresent(user -> {
            throw new EntityExistException("User with this email already exists!");
        });

        User user = userMapper.toEntity(dto);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(dto.password()));
        log.info("User with email: {} registered successfully!", dto.email());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserReqRespDto login(UserReqRespDto credentialsDto) {
        log.info("Logging in user with email: {}", credentialsDto.email());
        User user = userRepository.findByEmail(credentialsDto.email())
                .orElseThrow(() -> new AuthorizeException("Invalid credentials!", HttpStatus.UNAUTHORIZED));
        if (!passwordEncoder.matches(credentialsDto.password(), user.getPassword())) {
            throw new AuthorizeException("Invalid credentials!");
        }
        log.info("User with email: {} logged in successfully!", credentialsDto.email());
        return userMapper.toDto(user);
    }

}