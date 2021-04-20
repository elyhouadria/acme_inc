package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ely.entities.UserOrder;
import com.ely.interfaces.ACMEUserOrderServicesRemote;

@Stateless
@LocalBean

public class ACMEUserOrderServices implements ACMEUserOrderServicesRemote {
	
	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;
	
	@Override
	public int AddUserOrder(UserOrder userOrder) {
		em.persist(userOrder);
		return userOrder.getId();
	}
	
	@Override
	public void DeleteUserOrder(int userOrderId) {
		em.remove(em.find(UserOrder.class, userOrderId));
	}
	
	@Override
	public void UpdateUserOrder(UserOrder userorder) {
		em.merge(userorder);
	}
	
	@Override
	public List<UserOrder> getAllUserOrders() {
		List<UserOrder> allUserOrders = em.createQuery("select e from UserOrder e", UserOrder.class).getResultList();
		return allUserOrders;
	}
	
}
