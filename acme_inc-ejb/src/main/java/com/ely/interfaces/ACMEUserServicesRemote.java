package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;


import com.ely.entities.User;

@Remote

public interface ACMEUserServicesRemote {

	int AddUser(User user);
	void DeleteUser(int userId);
	List<User> searchUsersByName(String searchString);
	User Authentication(String email, String password);
	void UpdateUser(User user);
	User getUserByEmailAndPassword(String email, String password);
	public List<User> getAllUsers();
}