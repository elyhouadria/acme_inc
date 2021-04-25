package com.ely.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ely.enums.OrderStatus;
import com.ely.enums.PayementStatus;
import com.ely.enums.PayementType;
import com.ely.enums.UserRole;

@ManagedBean(name ="dataBean")
@ApplicationScoped

public class DataBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public UserRole[] getUserRoles() {
		return UserRole.values();
	}
	
	public PayementStatus[] getPayementStatus() {
		return PayementStatus.values();
	}
	
	public PayementType[] getPayementType() {
		return PayementType.values();
	}
	
	public OrderStatus[] getOrderStatus() {
		return OrderStatus.values();
	}
	
}
