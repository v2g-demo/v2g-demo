package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(exclude = "character")
public class User {

    @Id
    @Column(length = 100)
    private String id;
    @Column(name = "login")
    private String login;
    @Column(name = "name")
    private String name;

    @Column(name = "password",length = 500)
    @JsonIgnore
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Character> characters;


  //@ElementCollection(fetch = FetchType.EAGER) 1 user = 1 role (no need for multiply roles)
    //@CollectionTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role {
        GUEST,
        PLAYER,
        OBSERVER,
        BOT
    }
}
