package com.anajlm.movieapi.controller;

import com.anajlm.movieapi.domain.Review;
import com.anajlm.movieapi.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReviewController {

    private ReviewRepository reviewRepository;
    private ModelMapper modelMapper;

    public ReviewController(ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> retrieveReviewDetails(@PathVariable Long id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(!optionalReview.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalReview.get());
    }



}
