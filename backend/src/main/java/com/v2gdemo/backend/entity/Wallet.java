package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

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

    private String reference;
    private Double balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "source")
    @JsonManagedReference("trans")
    private List<Transaction> transactions;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "object_id", referencedColumnName = "id")
//    @JsonManagedReference("wallet")
//    private Object object;

    @UpdateTimestamp
    private Date updatedAt;
}
