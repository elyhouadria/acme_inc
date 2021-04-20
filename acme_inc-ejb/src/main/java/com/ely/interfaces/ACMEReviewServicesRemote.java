package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Review;

@Remote

public interface ACMEReviewServicesRemote {

	List<Review> getAllReviews();

	void DeleteReview(int reviewId);

	void UpdateReview(Review review);

}
