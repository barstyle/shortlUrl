package com.example.shortlurl.controllers;

import com.example.shortlurl.models.ShortUrl;
import com.example.shortlurl.services.ShortUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "api/v1/")
@Slf4j
public class ShortUrlRestController {

    ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlRestController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }


    @PostMapping
    public ShortUrl save(@RequestBody ShortUrl shortUrl) {
        if (shortUrlService.getShortUrlByOriginalUrl(shortUrl.getOriginalUrl()) == null) {
            shortUrlService.save(shortUrl.getOriginalUrl());
            log.info("save - " + shortUrlService.findAllShortUrls() + Thread.currentThread());
        } else {
            log.isDebugEnabled();
            log.info("this url already have");
        }
        return shortUrlService.getShortUrlByOriginalUrl(shortUrl.getOriginalUrl());
    }

}
