package com.example.job_app.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    Review addReview(Long companyId, Review review);

    Review getReview(Long companyId, Long reviewId);

    Review deleteReview(Long companyId, Long reviewId);

    Review updateReview(Long companyId, Long reviewId, Review review);
}
