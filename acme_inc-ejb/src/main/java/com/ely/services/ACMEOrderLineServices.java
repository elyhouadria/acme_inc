package com.ely.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ely.entities.OrderLine;
import com.ely.interfaces.ACMEOrderLineServicesRemote;


@Stateless
@LocalBean
public class ACMEOrderLineServices implements ACMEOrderLineServicesRemote {
	
	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;
	
	@Override
	public int AddOrderLine(OrderLine orderLine) {
		em.persist(orderLine);
		return orderLine.getId();
	}
	
	@Override
	public void DeleteUser(int orderLineId) {
		em.remove(em.find(OrderLine.class, orderLineId));
	}
	
	@Override
	public void updateOrderLine(OrderLine orderline) {
		em.merge(orderline);
	}
	
}
