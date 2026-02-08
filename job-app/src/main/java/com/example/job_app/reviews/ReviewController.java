package com.example.job_app.reviews;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews(@PathVariable Long companyId) {
        return reviewService.getAllReviews(companyId);
    }

    @PostMapping("/reviews")
    public Review addReview(@PathVariable Long companyId, @RequestBody Review review) {
        return reviewService.addReview(companyId, review);
    }

    @GetMapping("/reviews/{reviewId}")
    public Review getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return reviewService.getReview(companyId, reviewId);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public Review deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return reviewService.deleteReview(companyId, reviewId);
    }

    @PutMapping("/reviews/{reviewId}")
    public Review updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        return reviewService.updateReview(companyId, reviewId, review);
    }
}