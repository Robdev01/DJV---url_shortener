package com.desafio.url_shortener.dto;

import jakarta.validation.constraints.NotBlank;


public record ShortenUrlRequest(

        @NotBlank(message = "URL is required")
        String url

) {
}
