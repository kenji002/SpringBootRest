package com.example.job_app.reviews.impl;

import java.util.List;

import com.example.job_app.company.CompanyService;
import com.example.job_app.reviews.Review;
import com.example.job_app.reviews.ReviewRepository;
import com.example.job_app.reviews.ReviewService;

import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        if (!companyService.existsById(companyId)) {
            throw new RuntimeException("Company not found");
        }
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public Review deleteReview(Long companyId, Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            reviewRepository.delete(review);
        }
        return review;
    }

    @Override
    public Review updateReview(Long companyId, Long reviewId, Review review) {
        Review existingReview = reviewRepository.findById(reviewId).orElse(null);
        if (existingReview != null) {
            existingReview.setTitle(review.getTitle());
            existingReview.setDescription(review.getDescription());
            existingReview.setRating(review.getRating());
            reviewRepository.save(existingReview);
        }
        return existingReview;
    }
}
