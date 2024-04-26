package com.dev.road.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users") // "users" 테이블에 매핑됩니다.
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String userUuid;

    @Enumerated(EnumType.STRING)
    private Role role;  // 문자열 대신 열거형 사용
}