package com.v2gdemo.backend.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {

  Wallet findByAddress(String address);
}
