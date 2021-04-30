package com.ely.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ely.entities.Category;
import com.ely.entities.Product;
import com.ely.interfaces.ACMEProductServicesRemote;


@Stateless
@LocalBean
public class ACMEProductServices implements ACMEProductServicesRemote {
	
	
	@PersistenceContext(unitName = "acme_inc-ejb")
	EntityManager em;
	
	@Override
	public int AddProduct(Product product) {
		em.persist(product);
		return product.getId();
	}
	
	@Override
	public void DeleteProduct(int productId) {
		em.remove(em.find(Product.class, productId));
	}
	
	@Override
	public void UpdateProduct(Product product) {
		em.merge(product);
	}
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts = em.createQuery("select e from Product e", Product.class).getResultList();				
		return allProducts;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> searchProducts(String searchString) {
		List<Product> searchProductResults = em.createQuery("select e from product e where e.productName=:searchString").getResultList();
		return searchProductResults;
	}
	
	@Override
	public Category findCategoryById(int categoryId) {
		Category category = em.find(Category.class, categoryId);
		return category;
	}
}
