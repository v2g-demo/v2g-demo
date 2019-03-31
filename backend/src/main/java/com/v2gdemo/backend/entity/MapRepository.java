package com.v2gdemo.backend.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends CrudRepository<Map, Long> { }
