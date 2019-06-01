package com.v2gdemo.backend.service;

import com.v2gdemo.backend.entity.*;
import com.v2gdemo.backend.entity.Object;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class BillingServiceTest {

  private WalletRepository walletRepository = mock(WalletRepository.class);
  private TransactionRepository transactionRepository = mock(TransactionRepository.class);

  @Test
  public void makeTransaction() {

    String firstAddress= "firstAddress";
    String secondAddresss= "secondAddress";

    Wallet firstWallet = new Wallet();
    firstWallet.setBalance(200000);

    Wallet secondWallet = new Wallet();
    secondWallet.setBalance(0);



    Long value = 30000L;
    String address = "some address";

    when(walletRepository.findByAddress(firstAddress)).thenReturn(firstWallet);
    when(walletRepository.findByAddress(secondAddresss)).thenReturn(secondWallet);

    BillingService billingService = new BillingService(walletRepository,transactionRepository);
    try {
      Transaction transaction = billingService.makeTransaction(firstAddress, secondAddresss, value);
      assertEquals(transaction.getValue(),value);
      assertEquals(transaction.getSource(),firstWallet);
    } catch (Exception ex){ex.printStackTrace();}

  }

  @Test
  public void makeTransactionWithoutMoney() {

    String firstAddress= "firstAddress";
    String secondAddresss= "secondAddress";

    Wallet firstWallet = new Wallet();
    firstWallet.setBalance(10000);

    Wallet secondWallet = new Wallet();
    secondWallet.setBalance(0);



    Long value = 30000L;
    String address = "some address";

    when(walletRepository.findByAddress(firstAddress)).thenReturn(firstWallet);
    when(walletRepository.findByAddress(secondAddresss)).thenReturn(secondWallet);

    BillingService billingService = new BillingService(walletRepository,transactionRepository);
    try {
      Transaction transaction = billingService.makeTransaction(firstAddress, secondAddresss, value);
      fail(); // Should have thrown an exception
    } catch (Exception ex){ex.printStackTrace();}

  }

  @Test
  public void makeTransactionWithWrongAddress() {

    String firstAddress= "firstAddress";
    String secondAddresss= "secondAddress";



    Wallet secondWallet = new Wallet();
    secondWallet.setBalance(0);



    Long value = 30000L;
    String address = "some address";

    when(walletRepository.findByAddress(firstAddress)).thenReturn(null);
    when(walletRepository.findByAddress(secondAddresss)).thenReturn(secondWallet);

    BillingService billingService = new BillingService(walletRepository,transactionRepository);
    try {
      Transaction transaction = billingService.makeTransaction(firstAddress, secondAddresss, value);
      fail(); // Should have thrown an exception
    } catch (Exception ex){ex.printStackTrace();}

  }

}
