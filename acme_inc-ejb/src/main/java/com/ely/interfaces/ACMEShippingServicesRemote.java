package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Shipping;

@Remote

public interface ACMEShippingServicesRemote {

	int addShipping(Shipping shipping);

	void updateShipping(Shipping shipping);
	
	public void deleteShipping(int shippingId);
	
	public List<Shipping> getAllShippings();

}
