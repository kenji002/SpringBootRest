package com.example.job_app.reviews;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        reviewService.addReview(companyId, review);
        return ResponseEntity.ok("Review added successfully");
    }

    @GetMapping("/reviews/{reviewId}")
    public Review getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return reviewService.getReview(companyId, reviewId);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        reviewService.deleteReview(companyId, reviewId);
        return ResponseEntity.ok("Review deleted successfully");
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
            @RequestBody Review review) {
        reviewService.updateReview(companyId, reviewId, review);
        return ResponseEntity.ok("Review updated successfully");
    }
}