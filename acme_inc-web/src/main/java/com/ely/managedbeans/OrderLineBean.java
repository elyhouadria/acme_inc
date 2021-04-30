package com.ely.managedbeans;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ely.entities.OrderLine;
import com.ely.entities.Product;
import com.ely.entities.UserOrder;
import com.ely.interfaces.ACMEOrderLineServicesRemote;

@ManagedBean(name = "orderLineBean")
@SessionScoped

public class OrderLineBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int selectedOrderLineId;
	private int selectedProductId;
	private int selectedUserOrderId;

	private int quantity;
	private Date orderLineDate;
	private Double orderLinePrice;

	private Product product;
	private UserOrder userOrder;

	private List<OrderLine> getAllOrderLines;

	@EJB
	ACMEOrderLineServicesRemote acmeOrderLineServicesRemote;

	@PostConstruct
	public void init() {
		orderLineDate = new Date();
		quantity = 1;
		orderLinePrice = 0.00;
		getAllOrderLines = acmeOrderLineServicesRemote.getAllOrderLines();
//		product = new Product();
//		userOrder = new UserOrder();
	}

	public void modifyOrderLine(OrderLine orderLine) {
		this.setQuantity(orderLine.getQuantity());
		this.setSelectedOrderLineId(orderLine.getId());
		this.setOrderLineDate(orderLine.getOrderLineDate());
		this.setOrderLinePrice(orderLine.getOrderLinePrice());
		this.setSelectedProductId(orderLine.getProduct().getId());
		if (orderLine.getUserOrder() != null) {
			this.setSelectedUserOrderId(orderLine.getUserOrder().getId());
		}
	}

	public void addOrderLine() throws ParseException {
		System.out.println("quantity :" + quantity);
		System.out.println("date :" + orderLineDate);
		System.out.println("orderLinePrice :" + orderLinePrice);

		OrderLine orderLine = new OrderLine(orderLineDate, quantity, orderLinePrice);

		Product selectedProduct = new Product();
		// UserOrder selectedUserOrder = new UserOrder();
		selectedProduct.setId(selectedProductId);
		// selectedUserOrder.setId(selectedUserOrderId);
		orderLine.setProduct(selectedProduct);
		// orderLine.setUserOrder(selectedUserOrder);
		acmeOrderLineServicesRemote.addOrderLine(orderLine);
	}

	public void updateOrderLine() {
		acmeOrderLineServicesRemote.updateOrderLine(new OrderLine(selectedOrderLineId, quantity, orderLineDate,
				orderLinePrice, acmeOrderLineServicesRemote.findProductById(selectedProductId),
				acmeOrderLineServicesRemote.findUserOrderById(selectedUserOrderId)));
	}

	public void removeOrderLine(int orderLineId) {
		acmeOrderLineServicesRemote.deleteOrderLine(selectedOrderLineId);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSelectedOrderLineId() {
		return selectedOrderLineId;
	}

	public void setSelectedOrderLineId(int selectedOrderLine) {
		this.selectedOrderLineId = selectedOrderLine;
	}

	public Date getOrderLineDate() {
		return orderLineDate;
	}

	public void setOrderLineDate(Date orderLineDate) {
		this.orderLineDate = orderLineDate;
	}

	public Double getOrderLinePrice() {
		return orderLinePrice;
	}

	public void setOrderLinePrice(Double OrderLinePrice) {
		this.orderLinePrice = OrderLinePrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	public List<OrderLine> getGetAllOrderLines() {
		getAllOrderLines = acmeOrderLineServicesRemote.getAllOrderLines();
		return getAllOrderLines;
	}

	public void setGetAllOrderLines(List<OrderLine> getAllOrderLines) {
		this.getAllOrderLines = getAllOrderLines;
	}

	public int getSelectedProductId() {
		return selectedProductId;
	}

	public void setSelectedProductId(int selectedProduct) {
		this.selectedProductId = selectedProduct;
	}

	public int getSelectedUserOrderId() {
		return selectedUserOrderId;
	}

	public void setSelectedUserOrderId(int selectedUserOrder) {
		this.selectedUserOrderId = selectedUserOrder;
	}
}
