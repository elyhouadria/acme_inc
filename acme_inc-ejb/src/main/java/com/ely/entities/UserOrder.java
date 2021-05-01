package com.ely.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ely.enums.OrderStatus;

@Entity

public class UserOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Temporal(TemporalType.DATE)
	private Date shippingDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="fk_userid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="fk_adressid")
	private Adress adress;
	
	@OneToMany(mappedBy="userorder")
	private List<OrderLine> productOrderList;
	
	
	//need to change this it's a many to one
	@OneToOne
	@JoinColumn(name="fk_shippingid")
	private Shipping shipping;
	
	@OneToOne
	@JoinColumn(name="fk_payementid")
	private Payement payement;
	

	public UserOrder() {}
	
	public UserOrder(Date orderDate,Date shippingDate,OrderStatus orderStatus,Double totalPrice, Shipping shipping) {
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.shipping = shipping;
	}
	
	public UserOrder(Date orderDate, Date shippingDate, OrderStatus orderStatus, Double totalPrice, User user, 	Adress adress) {
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.user = user;
		this.adress =adress;
	}

	public UserOrder(Date orderDate, Date shippingDate, OrderStatus orderStatus, Double totalPrice, User user, 	Adress adress, Shipping shipping, Payement payement) {
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.user = user;
		this.adress =adress;
		this.shipping = shipping;
		this.payement = payement;
	}
	
	public UserOrder(int id,  Date orderDate, Date shippingDate, OrderStatus orderStatus, Double totalPrice, User user, 	Adress adress, Shipping shipping, Payement payement) {
		this.id = id;
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.user = user;
		this.adress =adress;
		this.shipping = shipping;
		this.payement = payement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setStatus(OrderStatus orderstatus) {
		this.orderStatus = orderstatus;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Payement getPayement() {
		return payement;
	}

	public void setPayement(Payement payement) {
		this.payement = payement;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public List<OrderLine> getProductOrderList() {
		return productOrderList;
	}

	public void setProductOrderList(List<OrderLine> productOrderList) {
		this.productOrderList = productOrderList;
	}

	@Override
	public String toString() {
		return id + " order date: " + orderDate + ", " + orderStatus + ", " + totalPrice;
//		return String.valueOf(id);
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
		UserOrder other = (UserOrder) obj;
		if (id != other.id)
			return false;
		return true;
	}			
}
