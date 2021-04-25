package com.ely.managedbeans;

import java.io.Serializable;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;


import com.ely.entities.Category;
import com.ely.entities.Product;
import com.ely.services.ACMECategoryServices;

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
	ACMECategoryServices acmecategoryservices;
	
	public void modifyCategory(Category category) {
		this.setSelectedCategoryId(category.getId());
		this.setName(category.getName());
		this.setDescription(category.getDescription());
	}
	
	public void addCategory() {
		acmecategoryservices.addCategory(new Category(name, description));		
	}
	public void removeCategory(int categoryId) {
		acmecategoryservices.deleteCategory(categoryId);
	}
	
	public void updateCategory() {
		acmecategoryservices.updateCategory(new Category(selectedCategoryId, name, description));
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
		getAllCategories = acmecategoryservices.getAllCategories();
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
