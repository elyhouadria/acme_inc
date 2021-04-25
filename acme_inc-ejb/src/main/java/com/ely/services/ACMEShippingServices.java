package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ely.entities.Shipping;
import com.ely.entities.User;
import com.ely.interfaces.ACMEShippingServicesRemote;

@Stateless
@LocalBean

public class ACMEShippingServices implements ACMEShippingServicesRemote {
	
	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;
	
	public int addShipping(Shipping shipping) {
		em.persist(shipping);
		return shipping.getId();
	}
	
	public void deleteShipping(int shippingId) {
		em.remove(em.find(User.class, shippingId));
	}
	
	public void updateShipping(Shipping shipping) {
		em.merge(shipping);
	}
		
	public List<Shipping> getAllShippings(){
		List<Shipping> allShipping = em.createQuery("select e from Shipping e", Shipping.class).getResultList();
		return allShipping;
	}

}
