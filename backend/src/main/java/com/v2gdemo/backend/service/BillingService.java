package com.v2gdemo.backend.service;

import com.v2gdemo.backend.entity.Object;
import com.v2gdemo.backend.entity.ObjectRepository;
import com.v2gdemo.backend.entity.Wallet;
import com.v2gdemo.backend.entity.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
  private WalletRepository walletRepository;
  private ObjectRepository objectRepository;
  public BillingService(WalletRepository walletRepository, ObjectRepository objectRepository){
    this.objectRepository = objectRepository;
    this.walletRepository = walletRepository;
  }
  public synchronized void makeTransaction(Object car, String address, long value) throws Exception{
    Wallet wallet = walletRepository.findByAddress(address);
    if (wallet == null) throw new Exception("Wrong address");
    if (car.getWallet().getBalance() < value) throw new Exception("Not enough money!");

   long balance = car.getWallet().getBalance();

    long chargerBalance = wallet.getBalance();


    balance = balance -value;
    chargerBalance = chargerBalance+value;


    car.getWallet().setBalance(balance);
    wallet.setBalance(chargerBalance);

    objectRepository.save(car);
    walletRepository.save(wallet);

  }
}
