package com.ely.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ely.entities.Payement;
import com.ely.entities.UserOrder;
import com.ely.enums.PayementStatus;
import com.ely.enums.PayementType;
import com.ely.interfaces.ACMEPayementServicesRemote;

@ManagedBean(name="payementBean")
@SessionScoped

public class PayementBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int selectedPayement;
	private Double amount;
	private String currency;
	private PayementStatus payementStatus;
	private PayementType payementType;
	private UserOrder userOrder;
	private Payement emptyPayement;
	
	private List<Payement> getAllPayements;
	
	@EJB
	ACMEPayementServicesRemote acmePayementServicesRemote;
	
	@PostConstruct
	public void init() { 
		getAllPayements= acmePayementServicesRemote.getAllPayements();	
	}
	
	public void modifyPayement(Payement payement) {
		this.setSelectedPayement(payement.getId());
		this.setAmount(payement.getAmount());
		this.setPayementStatus(payement.getPayementStatus());
		this.setUserOrder(payement.getUserorder());
	}
	
	public void addPayement() {
		acmePayementServicesRemote.AddPayement(new Payement(amount, payementStatus, payementType, currency));
	}
	
	public void updatePayement() {
		acmePayementServicesRemote.UpdatePayement(new Payement(selectedPayement, amount, payementStatus, payementType, currency, userOrder));
		
	}
	
	public void removePayement(int payementId) {
		acmePayementServicesRemote.DeletePayement(payementId);		
	}
	
	public int getSelectedPayement() {
		return selectedPayement;
	}

	public void setSelectedPayement(int selectedPayement) {
		this.selectedPayement = selectedPayement;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PayementStatus getPayementStatus() {
		return payementStatus;
	}

	public void setPayementStatus(PayementStatus payementStatus) {
		this.payementStatus = payementStatus;
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	public List<Payement> getGetAllPayements() {
		getAllPayements = acmePayementServicesRemote.getAllPayements();
		return getAllPayements;
	}

	public void setGetAllPayements(List<Payement> getAllPayements) {
		this.getAllPayements = getAllPayements;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public PayementType getPayementType() {
		return payementType;
	}

	public void setPayementType(PayementType payementType) {
		this.payementType = payementType;
	}

	public Payement getEmptyPayement() {
		return emptyPayement;
	}

	public void setEmptyPayement(Payement emptyPayement) {
		this.emptyPayement = emptyPayement;
	}
	
	
}
