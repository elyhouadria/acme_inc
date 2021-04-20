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
	private OrderStatus orderstatus;
	
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="fk_userid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="fk_adressid")
	private Adress adress;
	
	@OneToMany(mappedBy="userorder")
	private List<OrderLine> productOrderList;
	
	@OneToOne
	@JoinColumn(name="fk_shippingid")
	private Shipping shipping;
	
	@OneToOne
	@JoinColumn(name="fk_payementid")
	private Payement payement;
	

	public UserOrder() {}

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

	public OrderStatus getOrderstatus() {
		return orderstatus;
	}

	public void setStatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
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
		
		
}
