package com.hunt.otziv.services;

import com.hunt.otziv.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAll();

    List<ReviewDto> findAllById(long id);

    List<ReviewDto> findAllByCompanyId(long id);

    List<ReviewDto> findAllByCategoryId(long id);

    void saveReview();
}
