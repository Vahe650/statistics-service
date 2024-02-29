package com.statistics.statisticsservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String email;

    private String password;

    private Role role = Role.USER;

}
