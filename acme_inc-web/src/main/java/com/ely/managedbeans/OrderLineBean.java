package com.ely.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ely.entities.OrderLine;
import com.ely.entities.Product;
import com.ely.entities.UserOrder;
import com.ely.services.ACMEOrderLineServices;

@ManagedBean(name = "orderLineBean")
@SessionScoped

public class OrderLineBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int quantity;

	private int selectedOrderLine;
	private Date orderLineDate;
	private Double itemPrice;
	private Product product;
	private UserOrder userOrder;

	private List<OrderLine> getAllOrderLines;

	@EJB
	ACMEOrderLineServices acmeOrderLineServices;

	public void modifyOrderLine(OrderLine orderLine) {
		this.setSelectedOrderLine(orderLine.getId());
		this.setOrderLineDate(orderLine.getOrderLineDate());
		this.setItemPrice(orderLine.getItemPrice());
		this.setProduct(orderLine.getProduct());
		this.setUserOrder(orderLine.getUserOrder());

	}

	public void addOrderLine() {
		acmeOrderLineServices.addOrderLine(new OrderLine(orderLineDate, itemPrice, product, userOrder));
	}

	public void removeOrderLine(int orderLineId) {
		acmeOrderLineServices.deleteOrderLine(selectedOrderLine);
	}

	public void updateOrderLine() {
		acmeOrderLineServices
				.updateOrderLine(new OrderLine(selectedOrderLine, orderLineDate, itemPrice, product, userOrder));
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSelectedOrderLine() {
		return selectedOrderLine;
	}

	public void setSelectedOrderLine(int selectedOrderLine) {
		this.selectedOrderLine = selectedOrderLine;
	}

	public Date getOrderLineDate() {
		return orderLineDate;
	}

	public void setOrderLineDate(Date orderLineDate) {
		this.orderLineDate = orderLineDate;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
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
		getAllOrderLines = acmeOrderLineServices.getAllOrderLines();
		return getAllOrderLines;
	}

	public void setGetAllOrderLines(List<OrderLine> getAllOrderLines) {
		this.getAllOrderLines = getAllOrderLines;
	}

}
