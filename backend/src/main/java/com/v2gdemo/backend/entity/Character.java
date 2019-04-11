package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Data
@Entity
@Table(name = "characters")
@EqualsAndHashCode(exclude = "user")

public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne()
    @JoinColumn(name="map_id")
    @JsonBackReference("chars")
    private Map map;

    @ManyToOne()
    @JoinColumn(name="user_id")
    @JsonBackReference("user")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "owner")
    private List<Object> objects = new ArrayList<>();

    @NotBlank
    private String name;

    private Role role;
    public enum Role {
        ORGANIZATION,
        PERSON,
        BOT
    }

    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;
}
