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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "admin_name", nullable = false)
    private String username;

    @OneToMany(mappedBy = "id")
    List<Manager> managerList;

    @OneToOne
            @JoinColumn(name = "user_id")
    User user;




}
