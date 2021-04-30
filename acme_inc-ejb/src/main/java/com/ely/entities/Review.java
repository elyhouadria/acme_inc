package com.ely.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Review implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String reviewString;
	private int rating;
	
	@ManyToOne
	@JoinColumn(name="fk_productid")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_userid")
	private User user;

	public Review() {}
	
	public Review(String reviewString, int rating) {
		this.reviewString = reviewString;
		this.rating = rating;
	}

	public Review(String reviewString, int rating, User user, Product product) {
		this.reviewString = reviewString;
		this.rating = rating;
		this.user = user;
		this.product = product;
	}
	
	public Review(int id, String reviewString, int rating, User user, Product product) {
		this.id = id;
		this.reviewString = reviewString;
		this.rating = rating;
		this.user = user;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
//		return id + ", " + reviewString + ", " + rating + ", " + product + ", " + user;
		return String.valueOf(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
