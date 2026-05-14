package com.desafio.url_shortener.controller;

import com.desafio.url_shortener.dto.ShortenUrlRequest;
import com.desafio.url_shortener.dto.ShortenUrlResponse;
import com.desafio.url_shortener.service.ShortUrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService service;

    @PostMapping("/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(

            @RequestBody
            @Valid
            ShortenUrlRequest request

    ) {

        ShortenUrlResponse response =
                service.createShortUrl(request);

        return ResponseEntity.ok(response);
    }
}
