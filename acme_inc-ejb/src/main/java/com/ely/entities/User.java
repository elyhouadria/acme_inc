package com.ely.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ely.enums.UserRole;

@Entity

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	private Boolean isActive;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Adress> userAdresses;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<UserOrder> userUserOrders;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Review> userReviews;

	public User() {}

	public User(String firstName, String lastName, String email, String password, Date creationDate, Boolean isActive, UserRole userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.isActive = isActive;
		this.userRole = userRole;
	}

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(int id, String firstName, String lastName, String email, String password, Date creationDate, Boolean isActive, UserRole userRole) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.isActive = isActive;
		this.userRole = userRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole role) {
		this.userRole = role;
	}

	public List<Adress> getUserAdresses() {
		return userAdresses;
	}

	public void setUserAdresses(List<Adress> userAdresses) {
		this.userAdresses = userAdresses;
	}

	public List<UserOrder> getuserUserOrders() {
		return userUserOrders;
	}

	public void setUserOrders(List<UserOrder> userUserOrders) {
		this.userUserOrders = userUserOrders;
	}

	public List<Review> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(List<Review> userReviews) {
		this.userReviews = userReviews;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}	
	
}
