package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Adress;

@Remote

public interface ACMEAdressServicesRemote {

	int AddAdress(Adress adress);

	void DeleteAdress(int adressId);

	void updateAdress(Adress adress);

	List<Adress> getAllAdresses();
		
}
