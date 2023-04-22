package com.hunt.otziv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "manager_name", nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    Admin admin;

    @OneToMany(mappedBy = "id")
    List<Worker> workerList;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;








}
