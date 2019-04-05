package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="source_id")
    @JsonBackReference("trans")
    private Wallet source;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="destination_id")
    private Wallet destination;*/

    @CreationTimestamp
    private Date createdAt;
}
