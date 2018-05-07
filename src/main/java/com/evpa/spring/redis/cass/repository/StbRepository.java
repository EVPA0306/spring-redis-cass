package com.evpa.spring.redis.cass.repository;

import com.evpa.spring.redis.cass.dao.Stb;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StbRepository extends CassandraRepository<Stb, String> {
}
