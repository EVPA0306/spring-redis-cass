package com.evpa.spring.redis.cass.controller;

import com.evpa.spring.redis.cass.dao.Stb;
import com.evpa.spring.redis.cass.service.StbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/v1")
public class StbController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StbController.class);

    @Autowired
    StbService service;

    @PostMapping(value = "/stb", consumes="application/json")
    public ResponseEntity createStb(@Valid @RequestBody Stb stb) {
        LOGGER.info("stb::{}",stb);
        service.save(stb);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/stb/invalidate")
    public ResponseEntity invalidateCache() {
        service.invalidate();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/stb/{key}/{dt}")
    public ResponseEntity updateLastUpdatedTime(@PathVariable long dt, @PathVariable String key) {
        LOGGER.info("key:: {} dt:: {}",key,dt);
        service.updateLastUpdatedTime(new Date(dt),key);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/stb/crc/{key}/{crcScheduled}")
    public ResponseEntity updateCrcScheduled(@PathVariable long crcScheduled, @PathVariable String key) {
        LOGGER.info("key:: {} crcScheduled:: {}",key, crcScheduled);
        service.updateCrcScheduled(crcScheduled, new Date(), key);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/stbs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStbs(@Valid @RequestBody Iterable<Stb> stbs) {
        service.saveAll(stbs);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/stb/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Stb findStb(@PathVariable String key) {
        LOGGER.info("key:: {}",key);
        return service.find(key).get();
    }

    @GetMapping(value = "/stb", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Stb> findAll() {
        return service.findAll();
    }
}
