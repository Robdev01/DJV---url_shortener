package com.desafio.url_shortener.dto;

import java.time.LocalDateTime;

public record  ListShortUrlResponse(

        Integer id,
        String shortCode,
        String originalUrl,
        LocalDateTime createdAt,
        LocalDateTime expiresAt

) {
}

