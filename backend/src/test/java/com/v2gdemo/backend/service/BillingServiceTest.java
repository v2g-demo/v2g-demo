package com.v2gdemo.backend.service;

import com.v2gdemo.backend.entity.Object;
import com.v2gdemo.backend.entity.ObjectRepository;
import com.v2gdemo.backend.entity.Wallet;
import com.v2gdemo.backend.entity.WalletRepository;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class BillingServiceTest {

  private ObjectRepository objectRepository = mock(ObjectRepository.class);
  private WalletRepository walletRepository = mock(WalletRepository.class);

  @Test
  public void makeTransaction() {

    Wallet wallet = new Wallet();
    wallet.setBalance(40000);

    Wallet walletForCar = new Wallet();
    walletForCar.setBalance(200000);


    Object car = new Object();
    car.setWallet(walletForCar);


    long value = 30000;
    String address = "some address";

    when(walletRepository.save(wallet)).thenReturn(null);
    when(objectRepository.save(car)).thenReturn(null);
    when(walletRepository.findByAddress(address)).thenReturn(wallet);

    BillingService billingService = new BillingService(walletRepository,objectRepository);
    try {
      billingService.makeTransaction(car, address, value);

    } catch (Exception ex){ex.printStackTrace();}
  }

  @Test
  public void makeTransactionWithoutMoney() {

    Wallet wallet = new Wallet();
    wallet.setBalance(40000);

    Wallet walletForCar = new Wallet();
    walletForCar.setBalance(1000);


    Object car = new Object();
    car.setWallet(walletForCar);


    long value = 30000;
    String address = "some address";

    when(walletRepository.save(wallet)).thenReturn(null);
    when(objectRepository.save(car)).thenReturn(null);
    when(walletRepository.findByAddress(address)).thenReturn(wallet);

    BillingService billingService = new BillingService(walletRepository, objectRepository);
    try {
      billingService.makeTransaction(car, address, value);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Test
  public void makeTransactionWithWrongAddress() {

    Wallet wallet = new Wallet();
    wallet.setBalance(40000);

    Wallet walletForCar = new Wallet();
    walletForCar.setBalance(1000);


    Object car = new Object();
    car.setWallet(walletForCar);


    long value = 30000;
    String address = "some address";

    when(walletRepository.save(wallet)).thenReturn(null);
    when(objectRepository.save(car)).thenReturn(null);
    when(walletRepository.findByAddress(address)).thenReturn(null);

    BillingService billingService = new BillingService(walletRepository, objectRepository);
    try {
      billingService.makeTransaction(car, address, value);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
