package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ely.entities.Adress;
import com.ely.entities.Product;
import com.ely.entities.User;
import com.ely.interfaces.ACMEAdressServicesRemote;
@Stateless
@LocalBean
public class ACMEAdressServices implements ACMEAdressServicesRemote {
	
	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;

	
	@Override
	public int addAdress(Adress adress) {
		em.persist(adress);
		return adress.getId();
	}
	
	@Override
	public void deleteAdress(int adressId) {
		em.remove(em.find(Adress.class, adressId));
	}
	
	@Override
	public void updateAdress(Adress adress) {
		em.merge(adress);
	}
	
	@Override
	public List<Adress> getAllAdresses(){
		List<Adress> allAdresses = em.createQuery("select e from Adress e", Adress.class).getResultList();
		return allAdresses;
	}
	
	public List<Adress> getAdressesByUserId(int userId){
		List<Adress> userAdresses = em.createQuery("select e from Adress e where e.id=:userId", Adress.class).getResultList();
		return userAdresses;
	}
	
	public User findUserById(int userId) {
		User user = em.find(User.class, userId);
		return user;
	}
	public Product findProductById(int productId) {
		Product product = em.find(Product.class, productId);
		return product;
	}
}
