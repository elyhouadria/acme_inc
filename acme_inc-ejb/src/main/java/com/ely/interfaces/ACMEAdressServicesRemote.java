package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Adress;
import com.ely.entities.User;

@Remote

public interface ACMEAdressServicesRemote {

	int addAdress(Adress adress);

	void deleteAdress(int adressId);

	void updateAdress(Adress adress);

	List<Adress> getAllAdresses();
	
	public User findUserById(int userId);
		
}
