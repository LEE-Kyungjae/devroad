package com.dev.road.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class TokenResponse {

    private String accessToken;
    private Long accessTokenExpiresIn;

}
