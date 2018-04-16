package com.evpa.spring.redis.cass.service;

import com.evpa.spring.redis.cass.dao.Stb;
import com.evpa.spring.redis.cass.repository.StbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StbService {

    @Autowired
    private StbRepository repository;

    public void save(Stb entity) {
        repository.save(entity);
    }

    public Optional<Stb> find(String key) {
        return repository.findById(key);
    }

    public Iterable<Stb> findAll() {
        return repository.findAll();
    }
}
