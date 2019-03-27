package com.v2gdemo.backend.restcontroller;

import com.v2gdemo.backend.entity.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CommonController<E extends AbstractEntity> {

  @PostMapping
  ResponseEntity<E> save(@RequestBody E entity);
  @GetMapping
  ResponseEntity<E> get(@RequestParam long id) throws Throwable;

}
