package com.example.shortlurl.services;

import com.example.shortlurl.models.ShortUrl;
import com.example.shortlurl.repositories.ShortUrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;

    }

    @Override
    public List<ShortUrl> findAllShortUrls() {
        return shortUrlRepository.findAll();
    }

    @Override
    public ShortUrl getShortUrlByOriginalUrl(String originalUrl) {
        return shortUrlRepository.findByOriginalUrl(originalUrl);
    }

    @Override
    public ShortUrl getOriginalUrlByShortUrl(String shortUrl) {
        return shortUrlRepository.findByShortUrl(shortUrl);
    }

    @Override
    public void save(String originalUrl) {
        ShortUrl shortUrl = ShortUrl.builder()
                .id(UUID.randomUUID())
                .originalUrl(originalUrl)
                .shortUrl(RandomStringUtils.randomAlphanumeric(6))
                .createDataTime(LocalDateTime.now())
                .countOfClick(0L)
                .build();

        shortUrlRepository.save(shortUrl);
    }

    @Override
    public void remove(ShortUrl shortUrl) {
        shortUrlRepository.delete(shortUrl);
    }

    @Override
    public ShortUrl getByShortUrl(String shortUrl) {
        return shortUrlRepository.findByShortUrl(shortUrl);
    }

    @Override
    public void update(ShortUrl shortUrl) {
        shortUrlRepository.saveAndFlush(shortUrl);
    }
}
