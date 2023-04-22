package com.hunt.otziv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bots")
public class Bots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String phone;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private boolean isActive;

    @ManyToMany
    @JoinTable(name = "bots_reviews",
            joinColumns = @JoinColumn(name = "bots_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id"))
    private List<Review> reviewList;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    Worker worker;
}
