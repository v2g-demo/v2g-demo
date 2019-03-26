package com.v2gdemo.backend.service;

import com.v2gdemo.backend.dao.CommonRepository;
import com.v2gdemo.backend.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class AbstractService<E extends AbstractEntity,R extends CommonRepository<E>> implements CommonService<E>  {


  protected final R repository;

  @Autowired
  public AbstractService(R repository) {
    this.repository = repository;
  }

  @Override
  public E save(E entity) {
    return repository.save(entity);
  }

  @Override
  public Optional<E> findById(long id) {
    return repository.findById(id);
  }
}
