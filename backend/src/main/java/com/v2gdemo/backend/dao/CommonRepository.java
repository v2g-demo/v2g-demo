package com.v2gdemo.backend.dao;

import com.v2gdemo.backend.entity.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface  CommonRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {

}
