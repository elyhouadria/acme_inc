package com.ely.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class OrderLine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderLineDate;
	
	private double itemPrice;
	
	@ManyToOne
	@JoinColumn(name="fk_productid")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_userorderid")
	private UserOrder userorder;

	public OrderLine() {}

	public OrderLine(Date orderLineDate, Double itemPrice, Product product, UserOrder userOrder) {
		this.orderLineDate = orderLineDate;
		this.itemPrice = itemPrice;
		this.product = product;
		this.userorder = userOrder;
	}

	public OrderLine(int id, Date orderLineDate, Double itemPrice, Product product, UserOrder userOrder) {
		this.id = id;
		this.orderLineDate = orderLineDate;
		this.itemPrice = itemPrice;
		this.product = product;
		this.userorder = userOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderLineDate() {
		return orderLineDate;
	}

	public void setOrderLineDate(Date orderLineDate) {
		this.orderLineDate = orderLineDate;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UserOrder getUserOrder() {
		return userorder;
	}

	public void setOrder(UserOrder userorder) {
		this.userorder = userorder;
	}	
}
