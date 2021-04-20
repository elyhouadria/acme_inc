package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Category;
import com.ely.entities.Product;

@Remote

public interface ACMECategoryServicesRemote {

	int AddCategory(Category category);

	void DeleteCatgeory(int categoryId);

	void updateCategory(Category category);
	
	List<Product> getCategoryProducts(int categoryId);

	List<Category> getAllCategories();
	
}
