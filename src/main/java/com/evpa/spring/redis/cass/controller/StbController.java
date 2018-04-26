package com.evpa.spring.redis.cass.controller;

import com.evpa.spring.redis.cass.dao.Stb;
import com.evpa.spring.redis.cass.service.StbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class StbController {

    @Autowired
    StbService service;

    @PostMapping(value = "/stb", consumes="application/json")
    public ResponseEntity createStb(@Valid @RequestBody Stb stb) {
        service.save(stb);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/stbs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStbs(@Valid @RequestBody Iterable<Stb> stbs) {
        service.saveAll(stbs);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/stb/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Stb findStb(@PathVariable String key) {
        return service.find(key).get();
    }

    @GetMapping(value = "/stb", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Stb> findAll() {
        return service.findAll();
    }
}
