package com.ely.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ely.entities.Adress;
import com.ely.entities.OrderLine;
import com.ely.entities.Payement;
import com.ely.entities.Shipping;
import com.ely.entities.User;
import com.ely.entities.UserOrder;
import com.ely.enums.OrderStatus;
import com.ely.interfaces.ACMEUserOrderServicesRemote;

@ManagedBean(name="userOrderBean")
@SessionScoped

public class UserOrderBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int selectedUserOrder;
	private Date orderDate;
	private Date shippingDate;
	private OrderStatus orderStatus;
	private Double totalPrice;
	private User user;
	private Adress adress;
	private Shipping shipping;
	private Payement payement;
	
	
	private List<OrderLine> productOrderList;
	
	private List<UserOrder> getAllUserOrders;
	
	@EJB
	ACMEUserOrderServicesRemote acmeUserOrderServicesRemote;
	
	public void modifyUserOrder(UserOrder userorder) {
		this.setOrderDate(userorder.getOrderDate());
		this.setShippingDate(userorder.getShippingDate());
		this.setOrderStatus(userorder.getOrderstatus());
		this.setTotalPrice(userorder.getTotalPrice());
		this.setUser(userorder.getUser());
		this.setAdress(userorder.getAdress());
		this.setShipping(userorder.getShipping());
		this.setPayement(userorder.getPayement());
	}
	
	public void addUserOrder() {
		acmeUserOrderServicesRemote.addUserOrder(new UserOrder(orderDate, shippingDate, orderStatus, totalPrice, user, adress, shipping, payement));
	}
	
	public void removeUserOrder(int userOrderId) {
		acmeUserOrderServicesRemote.deleteUserOrder(userOrderId);
	}
	
	public void updateUserOrder() {
		acmeUserOrderServicesRemote.updateUserOrder(new UserOrder(selectedUserOrder, orderDate, shippingDate, orderStatus, totalPrice, user, adress, shipping, payement));
	}
	
	public int getSelectedUserOrder() {
		return selectedUserOrder;
	}

	public void setSelectedUserOrder(int selectedUserOrder) {
		this.selectedUserOrder = selectedUserOrder;
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

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
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

	public Payement getPayement() {
		return payement;
	}

	public void setPayement(Payement payement) {
		this.payement = payement;
	}

	public List<OrderLine> getProductOrderList(int userOrderId) {
		productOrderList = acmeUserOrderServicesRemote.getUserOrderOrderlines(userOrderId);
		return productOrderList;
	}

	public void setProductOrderList(List<OrderLine> productOrderList) {
		this.productOrderList = productOrderList;
	}

	public List<UserOrder> getGetAllUserOrders() {
		getAllUserOrders = acmeUserOrderServicesRemote.getAllUserOrders();
		return getAllUserOrders;
	}

	public void setGetAllUserOrders(List<UserOrder> getAllUserOrders) {
		this.getAllUserOrders = getAllUserOrders;
	}
}
