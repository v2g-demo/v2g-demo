package com.v2gdemo.backend.restcontroller;

import com.v2gdemo.backend.entity.AbstractEntity;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import com.v2gdemo.backend.service.AbstractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractController<E extends AbstractEntity, S extends AbstractService> implements CommonController<E> {

  private final S service;

  public AbstractController(S service) {
    this.service = service;

  }

  @Override
  public ResponseEntity<E> save( E entity){
    service.save(entity);
    return new ResponseEntity<E>(HttpStatus.ACCEPTED);

  }

  @Override
  public ResponseEntity<E> get(long id) throws Throwable{
    return (ResponseEntity<E>) service.findById(id).map(ResponseEntity::ok).orElseThrow(()->{
      return new ServerException("cant get entity with id:"+id);
    });
  }
}

