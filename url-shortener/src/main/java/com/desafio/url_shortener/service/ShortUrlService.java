package com.desafio.url_shortener.service;

import com.desafio.url_shortener.dto.ShortenUrlRequest;
import com.desafio.url_shortener.dto.ShortenUrlResponse;
import com.desafio.url_shortener.entity.ShortUrl;
import com.desafio.url_shortener.repository.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final ShortUrlRepository repository;

    private static final String CHARS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public ShortenUrlResponse createShortUrl(
            ShortenUrlRequest request
    ) {

        String shortCode;

        do {

            shortCode = generateShortCode();

        } while (repository.existsByShortCode(shortCode));

        ShortUrl entity = ShortUrl.builder()
                .originalUrl(request.url())
                .shortCode(shortCode)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusDays(30))
                .build();

        repository.save(entity);

        return new ShortenUrlResponse(
                "http://localhost:8080/" + shortCode
        );
    }

    private String generateShortCode() {

        Random random = new Random();

        int size = 5;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {

            int index =
                    random.nextInt(CHARS.length());

            builder.append(
                    CHARS.charAt(index)
            );
        }

        return builder.toString();
    }

    public String getOriginalUrl(String shortCode) {

        ShortUrl entity = repository
                .findByShortCode(shortCode)
                .orElseThrow(() ->
                        new RuntimeException("URL not found")
                );

        if (entity.getExpiresAt()
                .isBefore(LocalDateTime.now())) {

            throw new RuntimeException("URL expired");
        }

        return entity.getOriginalUrl();
    }


}
