package com.ely.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
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

@ManagedBean(name = "userOrderBean")
@SessionScoped

public class UserOrderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int selectedUserOrderId;
	private int selectedUserId;
	private int selectedShippingId;
	private int selectedPayementId;
	private int selectedAdressId;

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

	@PostConstruct
	public void init() {
		orderDate = new Date();
		shippingDate = new Date();
		totalPrice = 0.00;

		getAllUserOrders = acmeUserOrderServicesRemote.getAllUserOrders();
	}

	@EJB
	ACMEUserOrderServicesRemote acmeUserOrderServicesRemote;

	public void modifyUserOrder(UserOrder userorder) {
		this.setSelectedUserOrderId(userorder.getId());
		this.setOrderDate(userorder.getOrderDate());
		this.setShippingDate(userorder.getShippingDate());
		this.setOrderStatus(userorder.getOrderStatus());
		this.setTotalPrice(userorder.getTotalPrice());

		if (userorder.getUser() != null) {
			this.setSelectedUserId(userorder.getUser().getId());
		}
		if (userorder.getAdress() != null) {
			this.setSelectedAdressId(userorder.getAdress().getId());
		}
		if (userorder.getShipping() != null) {
			this.setSelectedShippingId(userorder.getShipping().getId());
		}
		if (userorder.getPayement() != null) {
			this.setSelectedPayementId(userorder.getPayement().getId());
		}
	}

	public void addUserOrder() {
		UserOrder userOrder = new UserOrder(orderDate, shippingDate, orderStatus, totalPrice, user, adress);
		User selectedUser = new User();
//		Shipping selectedShipping = new Shipping();
		Adress selectedAdress = new Adress();
		selectedUser.setId(selectedUserId);
		selectedAdress.setId(selectedAdressId);
//		selectedShipping.setId(selectedShippingId);
//		selectedPayement.setId(selectedPayementId);
		userOrder.setUser(selectedUser);
		userOrder.setAdress(selectedAdress);
//		userOrder.setShipping(selectedShipping);
//		userOrder.setPayement(selectedPayement);
		acmeUserOrderServicesRemote.addUserOrder(userOrder);
	}

	public void removeUserOrder(int userOrderId) {
		acmeUserOrderServicesRemote.deleteUserOrder(userOrderId);
	}

	public void updateUserOrder() {
		acmeUserOrderServicesRemote.updateUserOrder(new UserOrder(selectedUserOrderId, orderDate, shippingDate,
				orderStatus, totalPrice, acmeUserOrderServicesRemote.findUserById(selectedUserId),
				acmeUserOrderServicesRemote.findAdressById(selectedAdressId),
				acmeUserOrderServicesRemote.findShippingById(selectedShippingId),
				acmeUserOrderServicesRemote.findPayementById(selectedPayementId)));
	}

	public int getSelectedUserOrderId() {
		return selectedUserOrderId;
	}

	public void setSelectedUserOrderId(int selectedUserOrder) {
		this.selectedUserOrderId = selectedUserOrder;
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

	public int getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

	public int getSelectedShippingId() {
		return selectedShippingId;
	}

	public void setSelectedShippingId(int selectedShippingId) {
		this.selectedShippingId = selectedShippingId;
	}

	public int getSelectedPayementId() {
		return selectedPayementId;
	}

	public void setSelectedPayementId(int selectedPayementId) {
		this.selectedPayementId = selectedPayementId;
	}

	public int getSelectedAdressId() {
		return selectedAdressId;
	}

	public void setSelectedAdressId(int selectedAdressId) {
		this.selectedAdressId = selectedAdressId;
	}
}
