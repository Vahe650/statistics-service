package com.statistics.statisticsservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.statistics.statisticsservice.dto.UserJwtResponseDto;
import com.statistics.statisticsservice.dto.UserReqRespDto;
import com.statistics.statisticsservice.hander.exception.AuthorizeException;
import com.statistics.statisticsservice.mapper.UserMapper;
import com.statistics.statisticsservice.model.Role;
import com.statistics.statisticsservice.model.User;
import com.statistics.statisticsservice.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Value("${jwt.secret}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(UserReqRespDto userDto) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + (60_000 * 60 * 24 * 10));

        return JWT.create()
                .withIssuer(userDto.email())
                .withIssuedAt(new Date())
                .withExpiresAt(validity)
                .withClaim("role", userDto.role().ordinal())
                .sign(Algorithm.HMAC256(this.secretKey));
    }

    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decoded = verifier.verify(token);

        Optional<User> oUser = userRepository.findByEmail(decoded.getIssuer());

        oUser.map(userMapper::toDto)
                .orElseThrow(() -> new AuthorizeException("Invalid token!", HttpStatus.UNAUTHORIZED));

        UserJwtResponseDto userJwtResponseDto = new UserJwtResponseDto()
                .email(decoded.getIssuer())
                .firstname(decoded.getClaim("firstname").asString())
                .lastname(decoded.getClaim("lastname").asString())
                .role(decoded.getClaim("role").as(Role.class));

        return new UsernamePasswordAuthenticationToken(userJwtResponseDto, null, AuthorityUtils.createAuthorityList(userJwtResponseDto.role().name()));
    }

    public Authentication validateTokenStrong(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decoded = verifier.verify(token);

        Optional<User> oUser = userRepository.findByEmail(decoded.getIssuer());

        UserReqRespDto user = oUser.map(userMapper::toDto)
                .orElseThrow(() -> new AuthorizeException("Invalid token!", HttpStatus.UNAUTHORIZED));

        return new UsernamePasswordAuthenticationToken(
                user,
                null,
                AuthorityUtils.createAuthorityList(user.role().name()));
    }

}