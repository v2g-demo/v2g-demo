package com.v2gdemo.googlemap.dao;

import com.v2gdemo.googlemap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByLogin(String log);
    Optional<User> findById(String id);
}
