package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ely.entities.Category;
import com.ely.entities.Product;
import com.ely.interfaces.ACMECategoryServicesRemote;

@Stateless
@LocalBean
public class ACMECategoryServices implements ACMECategoryServicesRemote {

	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;

	@Override
	public int addCategory(Category category) {
		em.persist(category);
		return category.getId();
	}

	@Override
	public void deleteCategory(int categoryId) {
		em.remove(em.find(Category.class, categoryId));
	}

	@Override
	public void updateCategory(Category category) {
		em.merge(category);
	}
	
	@Override
	public List<Category> getAllCategories(){
		List<Category> getAllCategories = em.createQuery("select e from Category e", Category.class).getResultList();
		return getAllCategories;
		}
	
	
	@Override
	public List<Product> getCategoryProducts(int categoryId) {
		List<Product> getCategoryProducts = em.createQuery("select e from product e where e.category=:categoryId", Product.class)
				.getResultList();
		return getCategoryProducts;
	}

}
