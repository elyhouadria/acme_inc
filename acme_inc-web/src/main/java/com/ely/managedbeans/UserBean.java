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
import com.ely.enums.UserRole;
import com.ely.interfaces.ACMEUserServicesRemote;

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
	private int selectedUserId;
	private UserRole userRole;
	
	private List<Adress> userAdresses;
	private List<Review> userReviews;
	private List<Order> userOrders;
	
	private List<User> getAllUsers;
		
	@EJB
	ACMEUserServicesRemote acmeUserServicesRemote;
	
	public void modifyUser(User user) {
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setEmail(user.getEmail());
		this.setIsActive(user.getIsActive());
		this.setPassword(user.getPassword());
		this.setCreationDate(user.getCreationDate());
		this.setUserRole(user.getUserRole());
		this.setSelectedUserId(user.getId());
	}
	
	public void addUser() {
		acmeUserServicesRemote.addUser(new User(firstName,lastName,email,password,creationDate,isActive,userRole));
	}
	
	public void removeUser(int userId) {
		acmeUserServicesRemote.deleteUser(userId);
	}
	
	public void updateUser() {
		acmeUserServicesRemote.updateUser(new User(selectedUserId, firstName, lastName, email, password, creationDate, isActive, userRole));
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

	public List<User> getGetAllUsers() {
		getAllUsers = acmeUserServicesRemote.getAllUsers();
		return getAllUsers;
	}
	
	public void setGetAllUsers(List<User> getAllUsers) {
		this.getAllUsers = getAllUsers;
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

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}
	
		public int getSelectedUserId() {
		return selectedUserId;
	}

	
	
}
