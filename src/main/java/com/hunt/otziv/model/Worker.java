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
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "worker_name", nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    Manager manager;

    @OneToMany(mappedBy = "id")
    List<Company> companyList;

    @OneToMany(mappedBy = "id")
    List<Bots> botsList;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;





}
