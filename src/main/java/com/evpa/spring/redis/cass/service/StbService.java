package com.evpa.spring.redis.cass.service;

import com.evpa.spring.redis.cass.dao.Stb;
import com.evpa.spring.redis.cass.repository.StbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class StbService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StbService.class);

    private StbRepository repository;

    public StbService() {}

    @Autowired
    public StbService(StbRepository repository) {
        this.repository = repository;
    }

    @Cacheable("stb")
    public void save(Stb entity) {
        repository.save(entity);
    }

    @Cacheable("stb")
    public void saveAll(Iterable<Stb> entities) {
        repository.saveAll(entities);
    }

    @Cacheable("stb")
    public Optional<Stb> find(String key) {
        return repository.findById(key);
    }

    @Cacheable("stb")
    public Iterable<Stb> findAll() {
        return repository.findAll();
    }

    @Cacheable("stb")
    public void updateLastUpdatedTime(final Date lastRequestTime, final String deviceId) {
        LOGGER.info("lastRequestTime:: {} deviceId:: {}", lastRequestTime, deviceId);
        Stb entity = repository.findById(deviceId).get();
        LOGGER.info("entity before update:: {}", entity);
        entity.setLastUpdated(lastRequestTime);
        LOGGER.info("entity after update:: {}", entity);
        repository.save(entity);
    }

    @Cacheable("stb")
    public void updateCrcScheduled(final long crcScheduled, final Date lastUpdatedDate, final String deviceId) {
        Stb entity = repository.findById(deviceId).get();
        entity.setChecksumScheduled(crcScheduled);
        entity.setLastUpdated(lastUpdatedDate);
        repository.save(entity);
    }

    @CacheEvict(cacheNames = "stb", allEntries=true)
    public void invalidate() {

    }
}
