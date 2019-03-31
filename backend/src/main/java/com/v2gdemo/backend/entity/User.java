package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(length = 100)
    private String id;
    @Column(name = "login")
    private String login;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "password",length = 500)
    @JsonIgnore
    private String password;
    private String location;

    @Column(name = "email")
    private String email;


    //@ElementCollection(fetch = FetchType.EAGER)
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
