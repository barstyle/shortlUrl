package com.example.shortlurl.services;

import com.example.shortlurl.models.ShortUrl;

import java.util.List;

public interface ShortUrlService {
    public List<ShortUrl> findAllShortUrls();
    public ShortUrl getShortUrlByOriginalUrl(String originalUrl);
    public ShortUrl getOriginalUrlByShortUrl(String shortUrl);
    public void save(String original);
    public void remove(ShortUrl shortUrl);
    public ShortUrl getByShortUrl(String shortUrl);
    public void update(ShortUrl shortUrl);

}
