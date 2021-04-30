package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Payement;

@Remote

public interface ACMEPayementServicesRemote {

	int AddPayement(Payement payement);

	void DeletePayement(int payementId);

	void UpdatePayement(Payement payement);

	List<Payement> getAllPayements();

}
