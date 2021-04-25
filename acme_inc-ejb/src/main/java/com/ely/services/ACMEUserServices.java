package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ely.entities.User;
import com.ely.interfaces.ACMEUserServicesRemote;

@Stateless
@LocalBean

public class ACMEUserServices implements ACMEUserServicesRemote {

	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;
	
//	@Override
//	public Employee getEmployeeByEmailAndPassword(String login, String password) {
//		TypedQuery<Employee> query = em
//				.createQuery("select e from Employee e where e.login=:login AND e.password=:password", Employee.class);
//		query.setParameter("login", login);
//		query.setParameter("password", password);
//		Employee employee = null;
//		try {
//			employee = query.getSingleResult();
//		} catch (Exception e) {
//			System.out.println("Erreur : " + e);
//		}
//		return employee;
//	}
	
	@Override
	public List<User> getAllUsers(){
		List<User> allUsers = em.createQuery("select e from User e", User.class).getResultList();
		return allUsers;
	}
	
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		TypedQuery<User> query = em
				.createQuery("select e from User e where e.email=:email AND e.password=:password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return user;
	}

	@Override
	public int addUser(User user) {
		em.persist(user);
		return user.getId();
	}
	
	@Override
	public void deleteUser(int userId) {
		em.remove(em.find(User.class, userId));
	}
	
	@Override
	public void updateUser(User user) {
		em.merge(user);
	}
		
	@Override
	@SuppressWarnings("unchecked")
	public List<User> searchUsersByName(String searchString) {
		List<User> searchUserResults = em.createQuery("select e from user e where e.firstname=:searchString or e:lastname=:searchString or e:email=:searchstring").getResultList();
		return searchUserResults;
	}
	
	@Override
	public User userAuthentication(String email, String password) {
		TypedQuery<User> query = em.createQuery("select e from user where e.email=:email and e.password=:password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return user;
	}
}
