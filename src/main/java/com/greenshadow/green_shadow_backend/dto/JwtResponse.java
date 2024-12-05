package com.greenshadow.green_shadow_backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
}
