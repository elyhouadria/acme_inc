package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Adress;

@Remote

public interface ACMEAdressServicesRemote {

	int addAdress(Adress adress);

	void deleteAdress(int adressId);

	void updateAdress(Adress adress);

	List<Adress> getAllAdresses();
		
}
