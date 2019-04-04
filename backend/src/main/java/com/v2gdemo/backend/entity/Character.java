package com.v2gdemo.backend.entity;

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
    private Map map;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "owner",cascade = CascadeType.ALL)
    private Set<Object> objects = new HashSet<>();

    @NotBlank
    private String name;

    private Role role;
    public enum Role {
        ORGANISATION,
        PERSON,
        BOT
    }

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
