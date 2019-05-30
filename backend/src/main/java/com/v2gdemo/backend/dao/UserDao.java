package com.v2gdemo.backend.dao;

import com.v2gdemo.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByLogin(String log);
    Optional<User> findById(long id);

}
