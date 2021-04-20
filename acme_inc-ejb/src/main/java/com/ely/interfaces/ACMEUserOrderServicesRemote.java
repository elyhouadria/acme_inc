package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.UserOrder;

@Remote

public interface ACMEUserOrderServicesRemote {

	int AddUserOrder(UserOrder userOrder);

	List<UserOrder> getAllUserOrders();

	void DeleteUserOrder(int userOrderId);

	void UpdateUserOrder(UserOrder userorder);

}
