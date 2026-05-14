package com.desafio.url_shortener.controller;

import com.desafio.url_shortener.dto.ShortenUrlRequest;
import com.desafio.url_shortener.dto.ShortenUrlResponse;
import com.desafio.url_shortener.service.ShortUrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService service;

    @PostMapping("/api/v1/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(

            @RequestBody
            @Valid
            ShortenUrlRequest request

    ) {

        ShortenUrlResponse response =
                service.createShortUrl(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(

            @PathVariable String shortCode

    ) {

        String originalUrl =
                service.getOriginalUrl(shortCode);

        return ResponseEntity
                .status(302)
                .header("Location", originalUrl)
                .build();
    }

}
