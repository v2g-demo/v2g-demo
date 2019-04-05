package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="car_id")
  @JsonBackReference("tasks")
  private Object car;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "object_id")
  @JsonBackReference("cars")
  private Object to;


}
