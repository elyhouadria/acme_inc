package com.ely.managedbeans;

import java.io.Serializable;
import java.util.List;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.ely.entities.Category;
import com.ely.entities.Product;
import com.ely.services.ACMECategoryServices;

@ManagedBean(name = "categoryBean")
@SessionScoped

public class CategoryBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String description;
	
	private List<Category> getAllCategories;
	
	
	private List<Product> productsInCategory;
	
	@EJB
	ACMECategoryServices acmecategoryservices;
	
	public void modify(Category category) {
		this.setName(category.getName());
		this.setDescription(category.getDescription());
	}
	public void addCategory() {
		acmecategoryservices.AddCategory(new Category(name, description));		
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Category> getAllCategories() {
		getAllCategories = acmecategoryservices.getAllCategories();
		return getAllCategories;
	}
	public void setGetAllCategories(List<Category> getAllCategories) {
		this.getAllCategories = getAllCategories;
	}
	public List<Product> getProductsInCategory() {
		return productsInCategory;
	}
	public void setProductsInCategory(List<Product> productsInCategory) {
		this.productsInCategory = productsInCategory;
	}
}
