package com.v2gdemo.backend.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends CrudRepository<Object, Long> { }
