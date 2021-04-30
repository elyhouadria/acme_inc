package com.ely.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ely.entities.Product;
import com.ely.entities.Review;
import com.ely.entities.User;
import com.ely.interfaces.ACMEReviewServicesRemote;

@ManagedBean(name = "reviewBean")
@SessionScoped

public class ReviewBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int selectedReviewId;
	private int selectedProductId;
	private int selectedUserId;
	private String reviewString;
	private int rating;

	private User user;
	private Product product;

	private List<Review> getAllReviews;

	@EJB
	ACMEReviewServicesRemote acmeReviewServicesRemote;
	
	@PostConstruct
	public void init() { 
		getAllReviews= acmeReviewServicesRemote.getAllReviews();	
	}

	public void modifyReview(Review review) {
		this.setSelectedReviewId(review.getId());
		this.setReviewString(review.getReviewString());
		this.setRating(review.getRating());
		this.setSelectedProductId((review.getProduct()).getId());
		this.setSelectedUserId((review.getUser()).getId());
	}

	public void addReview() {

		Review review = new Review(reviewString, rating);
		Product selectedProduct = new Product();
		User selectedUser = new User();
		selectedUser.setId(selectedUserId);
		selectedProduct.setId(selectedProductId);
		review.setUser(selectedUser);
		review.setProduct(selectedProduct);
		acmeReviewServicesRemote.addReview(review);
	}

	public void updateReview() {
		acmeReviewServicesRemote.updateReview(new Review(selectedReviewId, reviewString, rating,
				acmeReviewServicesRemote.findUserById(selectedUserId),
				acmeReviewServicesRemote.findProductById(selectedProductId)));
	}

	public void removeReview(int reviewId) {
		acmeReviewServicesRemote.deleteReview(reviewId);
	}

	public int getSelectedReviewId() {
		return selectedReviewId;
	}

	public void setSelectedReviewId(int selectedReview) {
		this.selectedReviewId = selectedReview;
	}

	public String getReviewString() {
		return reviewString;
	}

	public void setReviewString(String reviewString) {
		this.reviewString = reviewString;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Review> getGetAllReviews() {
		getAllReviews = acmeReviewServicesRemote.getAllReviews();
		return getAllReviews;
	}

	public void setGetAllReviews(List<Review> getAllReviews) {
		this.getAllReviews = getAllReviews;
	}

	public int getSelectedProductId() {
		return selectedProductId;
	}

	public void setSelectedProductId(int selectedProductId) {
		this.selectedProductId = selectedProductId;
	}

	public int getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

}
