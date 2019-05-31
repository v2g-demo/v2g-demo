package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @PrePersist
    public void prePersist(){
      address = object.getName();

    }
    private String address;


    private long balance;

    @OneToOne(mappedBy = "wallet")
    private Object object;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "source")
    @JsonManagedReference("trans")
    private List<Transaction> transactions;

    @UpdateTimestamp
    private Date updatedAt;
}
