package com.example.shortlurl.controllers;

import com.example.shortlurl.models.ShortUrl;
import com.example.shortlurl.services.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/{url}")
    public ModelAndView getOriginalUrl(@PathVariable(name = "url") String url) {
        ShortUrl byShortUrl = shortUrlService.getByShortUrl(url);
        byShortUrl.incrementCount();
        shortUrlService.update(byShortUrl);

        return new ModelAndView("redirect:"
                                + shortUrlService.getOriginalUrlByShortUrl(url).getOriginalUrl());
    }
}
