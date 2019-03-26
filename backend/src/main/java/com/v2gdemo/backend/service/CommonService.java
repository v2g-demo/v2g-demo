package com.v2gdemo.backend.service;

import com.v2gdemo.backend.entity.AbstractEntity;

import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {

E save(E entity);
 Optional<E> findById(long id);
}
