package com.ely.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.criteria.Order;

import com.ely.entities.Adress;
import com.ely.entities.Review;
import com.ely.entities.User;
import com.ely.services.ACMEUserServices;

@ManagedBean(name="userBean")
@SessionScoped

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date creationDate;
	private Boolean isActive;
	
	private List<Adress> userAdresses;
	private List<Review> userReviews;
	private List<Order> userOrders;
	
	private List<User> getAllUsers;
		
	@EJB
	ACMEUserServices acmeuserservices;
	
	public void modifyUser(User user) {
		this.setFirstName(user.getEmail());
		this.setLastName(user.getLastName());
		this.setEmail(user.getEmail());
		this.setPassword(user.getPassword());
		this.setCreationDate(user.getCreationDate());
	}
	
	public void addUser() {
		acmeuserservices.AddUser(new User(firstName,lastName,email,password,creationDate,isActive));
	}
	
	public void removeEmployee(int employeeId) {
		acmeuserservices.DeleteUser(employeeId);
	}
	
	public void updateUser() {
		acmeuserservices.UpdateUser(new User(firstName, lastName, email, password, creationDate, isActive));
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

	public List<Adress> getUserAdresses() {
		return userAdresses;
	}
	public void setUserAdresses(List<Adress> userAdresses) {
		this.userAdresses = userAdresses;
	}
	public List<Review> getUserReviews() {
		return userReviews;
	}
	public void setUserReviews(List<Review> userReviews) {
		this.userReviews = userReviews;
	}
	public List<Order> getUserOrders() {
		return userOrders;
	}
	public void setUserOrders(List<Order> userOrders) {
		this.userOrders = userOrders;
	}
	public ACMEUserServices getAcmeuserservices() {
		return acmeuserservices;
	}
	public void setAcmeuserservices(ACMEUserServices acmeuserservices) {
		this.acmeuserservices = acmeuserservices;
	}
	public List<User> getGetAllUsers() {
		getAllUsers = acmeuserservices.getAllUsers();
		return getAllUsers;
	}
	
	public void setGetAllUsers(List<User> getAllUsers) {
		this.getAllUsers = getAllUsers;
	}
}
