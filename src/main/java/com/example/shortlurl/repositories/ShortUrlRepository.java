package com.example.shortlurl.repositories;

import com.example.shortlurl.models.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, UUID> {

    public ShortUrl findByShortUrl(String shortUrl);
    public ShortUrl findByOriginalUrl(String originalUrl);
    public List<ShortUrl> getAllByCreateDataTimeBefore(LocalDateTime localDateTime);

}
