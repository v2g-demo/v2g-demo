package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @JoinColumn(name="car_id")
  @Column(name = "car")
 @JsonBackReference("tasks")
  private Long car;

  @NotNull
  @JoinColumn(name = "object_id")
  @Column(name = "to_car")
  @JsonBackReference("cars")
  private Long to;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Status status;
  public enum Status {
    NEW,
    DONE,
  }

  @CreationTimestamp
  private Date createdAt;

  @UpdateTimestamp
  private Date updatedAt;
}
