package com.hunt.otziv.services;

import com.hunt.otziv.dto.ReviewDto;
import com.hunt.otziv.model.Review;
import com.hunt.otziv.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService{

    private  final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }


    // Метод составления списка всех отзывов в системе
    @Override
    public List<ReviewDto> findAll() {
        return repository.findAll().stream()
                .map(this::toDto)

                .collect(Collectors.toList());
    }

    // Метод составления списка отзывов по выбранному id
    @Override
    public List<ReviewDto> findAllById(long id) {
        return  repository.findAllById(id).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Метод составления списка отзывов по выбранной компании
    @Override
    public List<ReviewDto> findAllByCompanyId(long id) {
        return  repository.findAllByCompany_id(id).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Метод составления списка отзывов по выбранной категории
    @Override
    public List<ReviewDto> findAllByCategoryId(long id) {
        return  repository.findAllByCategory_id(id).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveReview() {

    }

    private ReviewDto toDto(Review review){
        return ReviewDto.builder()
                .id(review.getId())
                .company(review.getCompany())
                .textReview(review.getTextReview())
                .check(review.isChecked())
                .pay(review.isPayed())
                .createDate(review.getCreateDate())
                .publicDate(review.getPublicDate())
                .modificateDate(review.getModificateDate())
                .build();
    }
}
