package com.evpa.spring.redis.cass.service;

import com.evpa.spring.redis.cass.dao.Stb;
import com.evpa.spring.redis.cass.repository.StbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StbService {


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
}
