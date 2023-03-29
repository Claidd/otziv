package com.hunt.otziv.dto;

import com.hunt.otziv.model.Company;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {
    private Long id;

    private Company company;

    private String textReview;

    private boolean check;

    private boolean pay;


    private Date createDate;

    private Date publicDate;

    private Date modificateDate;



}
