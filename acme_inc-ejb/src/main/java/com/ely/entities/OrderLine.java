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
	
	
	
	@ManyToOne
	@JoinColumn(name="fk_productid")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_userorderid")
	private UserOrder userorder;
	
	private double orderLinePrice;

	public OrderLine() {}
	
	public OrderLine(Date orderLineDate, int quantity, Double itemPrice) {
		this.orderLineDate = orderLineDate;
		this.quantity = quantity;
		this.orderLinePrice = itemPrice;
	}
	
	public OrderLine(Date orderLineDate, int quantity, Double itemPrice, Product product) {
		this.orderLineDate = orderLineDate;
		this.quantity = quantity;
		this.orderLinePrice = itemPrice;
		this.product = product;
	}
	
	public OrderLine(Date orderLineDate, int quantity, Double itemPrice, Product product, UserOrder userOrder) {
		this.orderLineDate = orderLineDate;
		this.quantity = quantity;
		this.orderLinePrice = itemPrice;
		this.product = product;
		this.userorder= userOrder;
	}

	public OrderLine(int id, int quantity, Date orderLineDate, Double itemPrice, Product product, UserOrder userOrder) {
		this.id = id;
		this.orderLineDate = orderLineDate;
		this.quantity = quantity;
		this.orderLinePrice = itemPrice;
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

	public double getOrderLinePrice() {
		return orderLinePrice;
	}

	public void setOrderLinePrice(double itemPrice) {
		this.orderLinePrice = itemPrice;
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

	public void setUserOrder(UserOrder userorder) {
		this.userorder = userorder;
	}

	@Override
	public String toString() {
//		return id + ", " + quantity + ", " + orderLineDate + ", " + itemPrice + ", " + product;
		return String.valueOf(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
