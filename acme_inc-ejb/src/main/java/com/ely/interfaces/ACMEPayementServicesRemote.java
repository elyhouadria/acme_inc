package com.ely.interfaces;

import javax.ejb.Remote;

import com.ely.entities.OrderLine;
import com.ely.entities.Payement;

@Remote

public interface ACMEPayementServicesRemote {

	int AddPayement(Payement payement);

	void DeletePayement(int payementId);

	void UpdatePayement(Payement payement);

}
