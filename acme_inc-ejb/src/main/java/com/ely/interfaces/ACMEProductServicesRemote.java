package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Category;
import com.ely.entities.Product;

@Remote

public interface ACMEProductServicesRemote {

	int AddProduct(Product product);

	void DeleteProduct(int productId);

	List<Product> getAllProducts();

	List<Product> searchProducts(String searchString);

	void UpdateProduct(Product product);
	
	public Category findCategoryById(int categoryId);

}
