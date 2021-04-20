package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ely.entities.Review;
import com.ely.interfaces.ACMEReviewServicesRemote;


@Stateless
@LocalBean

public class ACMEReviewServices implements ACMEReviewServicesRemote {

	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;

	@Override
	public List<Review> getAllReviews() {
		List<Review> allReviews = em.createQuery("select e from Review e", Review.class).getResultList();
		return allReviews;
	}

	@Override
	public void DeleteReview(int reviewId) {
		em.remove(em.find(Review.class, reviewId));
	}
	
	@Override
	public void UpdateReview(Review review) {
		em.merge(review);
	}

}
