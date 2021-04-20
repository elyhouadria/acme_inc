package com.ely.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ely.entities.OrderLine;
import com.ely.entities.Payement;
import com.ely.interfaces.ACMEPayementServicesRemote;


@Stateless
@LocalBean
public class ACMEPayementServices implements ACMEPayementServicesRemote {

	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;
	
	@Override
	public int AddPayement(Payement payement) {
		em.persist(payement);
		return payement.getId();
	}
	
	@Override
	public void DeletePayement(int payementId) {
		em.remove(em.find(Payement.class, payementId));
	}
	
	@Override
	public void UpdatePayement(OrderLine orderline) {
		em.merge(orderline);
	}
	
	

}
