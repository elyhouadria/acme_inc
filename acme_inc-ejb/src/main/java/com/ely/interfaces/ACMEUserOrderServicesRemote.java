package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.Adress;
import com.ely.entities.OrderLine;
import com.ely.entities.Payement;
import com.ely.entities.Product;
import com.ely.entities.Shipping;
import com.ely.entities.User;
import com.ely.entities.UserOrder;

@Remote

public interface ACMEUserOrderServicesRemote {

	int addUserOrder(UserOrder userOrder);

	List<UserOrder> getAllUserOrders();

	void deleteUserOrder(int userOrderId);

	void updateUserOrder(UserOrder userorder);
	
	public List<OrderLine> getUserOrderOrderlines(int userOrderId);
	
	public User findUserById(int userId);
	
	public Product findProductById(int productId);
	
	public Payement findPayementById(int payementId);
	
	public Shipping findShippingById(int shippingId);
	
	public Adress findAdressById(int adressId);

}
