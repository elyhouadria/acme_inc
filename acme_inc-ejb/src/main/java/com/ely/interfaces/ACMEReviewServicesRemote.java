package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Product;
import com.ely.entities.Review;
import com.ely.entities.User;

@Remote

public interface ACMEReviewServicesRemote {

	List<Review> getAllReviews();

	void deleteReview(int reviewId);

	void updateReview(Review review);

	int addReview(Review review);
	
	public User findUserById(int userId);
	
	public Product findProductById(int productId);

}
