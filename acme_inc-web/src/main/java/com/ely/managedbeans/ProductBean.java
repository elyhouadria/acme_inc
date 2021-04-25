package com.ely.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ely.entities.Category;
import com.ely.entities.Product;
import com.ely.services.ACMEProductServices;

@ManagedBean(name = "productBean")
@SessionScoped

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int selectedProductId;
	private int selectedCategorytId;
	private String productName;
	private String productDescription;
	private double doubleProductPrice;
	private String imageURL;
	private Category category;

	@EJB
	ACMEProductServices acmeproductservices;

	private List<Product> getAllProducts;

	public void modifyProduct(Product product) {
		this.setSelectedProductId(product.getId());
		this.setProductName(product.getProductName());
		this.setProductDescription(product.getProductDescription());
		this.setDoubleProductPrice(product.getProductPrice());
		this.setImageURL(product.getImageURL());
		this.setCategory(product.getCategory());

	}

	public void addProduct() {
		Product product = new Product(productName, productDescription, doubleProductPrice, imageURL, category);
		Category selectedCategory = new Category();
		selectedCategory.setId(selectedProductId);
		product.setCategory(selectedCategory);
		acmeproductservices.AddProduct(product);
	}

	public void updateProduct() {
		acmeproductservices.UpdateProduct(new Product(selectedProductId, productName, productDescription,
				doubleProductPrice, imageURL, category));
	}

	public void removeProduct(int productId) {
		acmeproductservices.DeleteProduct(productId);
	}

	public int getSelectedProductId() {
		return selectedProductId;
	}

	public void setSelectedProductId(int selectedProductId) {
		this.selectedProductId = selectedProductId;
	}

	public int getSelectedCategorytId() {
		return selectedCategorytId;
	}

	public void setSelectedCategorytId(int selectedCategorytId) {
		this.selectedCategorytId = selectedCategorytId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Product> getGetAllProducts() {
		getAllProducts = acmeproductservices.getAllProducts();
		return getAllProducts;
	}

	public void setGetAllProducts(List<Product> getAllProducts) {
		this.getAllProducts = getAllProducts;
	}

	public double getDoubleProductPrice() {
		return doubleProductPrice;
	}

	public void setDoubleProductPrice(double doubleProductPrice) {
		this.doubleProductPrice = doubleProductPrice;
	}
}
