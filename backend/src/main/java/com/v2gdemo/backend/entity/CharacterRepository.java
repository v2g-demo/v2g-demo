package com.v2gdemo.backend.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> { }
