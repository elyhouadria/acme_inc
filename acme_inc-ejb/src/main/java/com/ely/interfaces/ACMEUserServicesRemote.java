package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;


import com.ely.entities.User;

@Remote

public interface ACMEUserServicesRemote {

	int addUser(User user);
	void deleteUser(int userId);
	List<User> searchUsersByName(String searchString);
	User userAuthentication(String email, String password);
	void updateUser(User user);
	User getUserByEmailAndPassword(String email, String password);
	public List<User> getAllUsers();
	public User findUserById(int userId);
}