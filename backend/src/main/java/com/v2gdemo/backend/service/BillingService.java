package com.v2gdemo.backend.service;

import com.v2gdemo.backend.entity.*;
import com.v2gdemo.backend.entity.Object;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
  private WalletRepository walletRepository;
  private TransactionRepository transactionRepository;
  public BillingService(WalletRepository walletRepository,TransactionRepository transactionRepository){
    this.transactionRepository = transactionRepository;
    this.walletRepository = walletRepository;
  }
  public synchronized Transaction makeTransaction(String fromAddress, String toAddress, long value) throws ServerException {
    Wallet from = walletRepository.findByAddress(fromAddress);
    Wallet to = walletRepository.findByAddress(toAddress);
    if (from == null || to == null) throw new ServerException("Wrong address");
    if (from.getBalance() < value) throw new ServerException("Not enough money!");

   long fromBalance = from.getBalance();

    long toBalance = to.getBalance();

 
    fromBalance -= value;
    toBalance += value;



    Transaction transaction = new Transaction();

    transaction.setSource(from);
    transaction.setValue(value);


    from.setBalance(fromBalance);
    to.setBalance(toBalance);


    transactionRepository.save(transaction);
    walletRepository.saveAll(List.of(from,to));
 return transaction;
  }
}
