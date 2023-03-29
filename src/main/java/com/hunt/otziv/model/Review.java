package com.hunt.otziv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String textReview;
    @Column(name = "checked")
    @ColumnDefault("false")
    private boolean checked;
    @Column(name = "payed")
    @ColumnDefault("false")
    private boolean payed;


    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date publicDate;
    @UpdateTimestamp
    private Date modificateDate;



}
