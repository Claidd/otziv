package com.hunt.otziv.repository;

import com.hunt.otziv.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllById(long id);
    List<Review> findAllByCompany_id(long id);
    List<Review> findAllByCategory_id(long id);
}
