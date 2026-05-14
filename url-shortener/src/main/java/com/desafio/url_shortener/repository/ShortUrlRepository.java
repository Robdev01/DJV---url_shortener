package com.desafio.url_shortener.repository;

import com.desafio.url_shortener.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository
        extends JpaRepository<ShortUrl, Integer> {

    Optional<ShortUrl> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);
}