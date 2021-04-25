package com.ely.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ely.entities.Shipping;
import com.ely.interfaces.ACMEShippingServicesRemote;

@ManagedBean
@SessionScoped

public class ShippingBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int selectedShipping;
	private String shippingName;
	private Double shippingPrice;
	
	private List<Shipping> allShippings;
	
	@EJB
	ACMEShippingServicesRemote acmeShippingServicesRemote;
	
	public void modifyShipping(Shipping shipping) {
		this.setSelectedShipping(shipping.getId());
		this.setShippingName(shipping.getShippingName());
		this.setShippingPrice(shipping.getShippingPrice());
	}
	
	public void addShipping() {
		acmeShippingServicesRemote.addShipping(new Shipping(shippingName, shippingPrice));
	}
	
	public void updateShipping() {
		acmeShippingServicesRemote.updateShipping(new Shipping(selectedShipping, shippingName, shippingPrice));
		
	}
	
	public void removeShipping(int shippingId) {
		acmeShippingServicesRemote.deleteShipping(shippingId);
	}
		
	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public Double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(Double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public List<Shipping> getAllShippings() {
		allShippings = acmeShippingServicesRemote.getAllShippings();
		return allShippings;
	}

	public void setAllShippings(List<Shipping> allShippings) {
		this.allShippings = allShippings;
	}

	public int getSelectedShipping() {
		return selectedShipping;
	}

	public void setSelectedShipping(int selectedShipping) {
		this.selectedShipping = selectedShipping;
	}

}
