package com.v2gdemo.backend.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
}
