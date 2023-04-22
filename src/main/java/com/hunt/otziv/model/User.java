package com.hunt.otziv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean archive;

    @Column(name = "activate_code")
    private String activateCode;

    @OneToOne
    @JoinColumn(name = "admin_id")
    Admin admin;

    @OneToOne
    @JoinColumn(name = "manager_id")
    Manager manager;

    @OneToOne
    @JoinColumn(name = "worker_id")
    Worker worker;
//    @OneToOne
//    User user;
}
