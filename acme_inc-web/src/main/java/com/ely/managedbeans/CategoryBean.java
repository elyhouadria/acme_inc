package com.ely.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;


import com.ely.entities.Category;
import com.ely.entities.Product;
import com.ely.interfaces.ACMECategoryServicesRemote;

@ManagedBean(name = "categoryBean")
@SessionScoped

public class CategoryBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private int selectedCategoryId;
	
	private List<Category> getAllCategories;
	private List<Product> productsInCategory;
	
	@EJB
	ACMECategoryServicesRemote acmeCategoryServicesRemote;
	
	@PostConstruct
	public void init() { 
		getAllCategories= acmeCategoryServicesRemote.getAllCategories();	
	}
	
	public void modifyCategory(Category category) {
		this.setSelectedCategoryId(category.getId());
		this.setName(category.getName());
		this.setDescription(category.getDescription());
	}
	
	public void addCategory() {
		acmeCategoryServicesRemote.addCategory(new Category(name, description));		
	}
	public void removeCategory(int categoryId) {
		acmeCategoryServicesRemote.deleteCategory(categoryId);
	}
	
	public void updateCategory() {
		acmeCategoryServicesRemote.updateCategory(new Category(selectedCategoryId, name, description));
	}
	
	public String getName() {
		return name;
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
		getAllCategories = acmeCategoryServicesRemote.getAllCategories();
		return getAllCategories;
	}
	public void setAllCategories(List<Category> getAllCategories) {
		this.getAllCategories = getAllCategories;
	}
	public List<Product> getProductsInCategory() {
		return productsInCategory;
	}
	public void setProductsInCategory(List<Product> productsInCategory) {
		this.productsInCategory = productsInCategory;
	}
	public int getSelectedCategoryId() {
		return selectedCategoryId;
	}
	public void setSelectedCategoryId(int selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}
}
