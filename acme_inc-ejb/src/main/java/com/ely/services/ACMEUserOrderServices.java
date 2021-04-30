package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ely.entities.Adress;
import com.ely.entities.OrderLine;
import com.ely.entities.Payement;
import com.ely.entities.Product;
import com.ely.entities.Shipping;
import com.ely.entities.User;
import com.ely.entities.UserOrder;
import com.ely.interfaces.ACMEUserOrderServicesRemote;

@Stateless
@LocalBean

public class ACMEUserOrderServices implements ACMEUserOrderServicesRemote {
	
	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;
	
	@Override
	public int addUserOrder(UserOrder userOrder) {
		em.persist(userOrder);
		return userOrder.getId();
	}
	
	@Override
	public void deleteUserOrder(int userOrderId) {
		em.remove(em.find(UserOrder.class, userOrderId));
	}
	
	@Override
	public void updateUserOrder(UserOrder userorder) {
		em.merge(userorder);
	}
	
	@Override
	public List<UserOrder> getAllUserOrders() {
		List<UserOrder> allUserOrders = em.createQuery("select e from UserOrder e", UserOrder.class).getResultList();
		return allUserOrders;
	}
	
	@Override
	public List<OrderLine> getUserOrderOrderlines(int userOrderId){ 
	List<OrderLine> userOrderOrderLines = em.createQuery("select e from OrderLine e where e.id=:userOrderId", OrderLine.class).getResultList();
			return userOrderOrderLines;
	}
	@Override
	public User findUserById(int userId) {
		User user = em.find(User.class, userId);
		return user;
	}
	@Override
	public Product findProductById(int productId) {
		Product product = em.find(Product.class, productId);
		return product;
	}
	@Override
	public Payement findPayementById(int payementId) {
		Payement payement = em.find(Payement.class, payementId);
		return payement;
	}
	@Override
	public Shipping findShippingById(int shippingId) {
		Shipping shipping = em.find(Shipping.class, shippingId);
		return shipping;
	}	
	@Override
	public Adress findAdressById(int adressId) {
		Adress adress = em.find(Adress.class, adressId);
		return adress;
	}	
}
