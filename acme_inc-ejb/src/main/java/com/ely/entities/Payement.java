package com.ely.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ely.enums.PayementStatus;
import com.ely.enums.PayementType;

@Entity

public class Payement implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Double amount;
	
	private String currency;
	
	@Enumerated(EnumType.STRING)
	private PayementStatus payementStatus;
	
	@Enumerated(EnumType.STRING)
	private PayementType payementType;
	
	@OneToOne(mappedBy="payement")
	private UserOrder userorder;

	public Payement() {}

	public Payement(Double amount, PayementStatus payementStatus, PayementType payementType, String currency, UserOrder userOrder) {
		this.amount = amount;
		this.payementStatus = payementStatus;
		this.payementType = payementType;
		this.currency = currency;
		this.userorder = userOrder;
	}
	public Payement(int id, Double amount, PayementStatus payementStatus, PayementType payementType, String currency, UserOrder userOrder) {
		this.id = id;
		this.amount = amount;
		this.payementStatus = payementStatus;
		this.payementType = payementType;
		this.currency = currency;
		this.userorder = userOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public PayementStatus getPayementStatus() {
		return payementStatus;
	}

	public void setPayementStatus(PayementStatus payementStatus) {
		this.payementStatus = payementStatus;
	}

	public PayementType getPayementType() {
		return payementType;
	}

	public void setPayementType(PayementType payementType) {
		this.payementType = payementType;
	}

	public UserOrder getUserorder() {
		return userorder;
	}

	public void setUserOrder(UserOrder userorder) {
		this.userorder = userorder;
	}
}
