package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ely.entities.Product;
import com.ely.entities.Review;
import com.ely.entities.User;
import com.ely.interfaces.ACMEReviewServicesRemote;


@Stateless
@LocalBean

public class ACMEReviewServices implements ACMEReviewServicesRemote {

	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;
	
	@Override
	public int addReview(Review review) {
		em.persist(review);
		return review.getId();
	}
	
	@Override
	public List<Review> getAllReviews() {
		List<Review> allReviews = em.createQuery("select e from Review e", Review.class).getResultList();
		return allReviews;
	}

	@Override
	public void deleteReview(int reviewId) {
		em.remove(em.find(Review.class, reviewId));
	}
	
	@Override
	public void updateReview(Review review) {
		em.merge(review);
	}
	@Override
	public User findUserById(int userId) {
		User user = em.find(User.class, userId);
		return user;
	}
	@Override
	public Product findProductById(int productId) {
		Product product = em.find(Product.class, productId);
		return product;
	}

}
