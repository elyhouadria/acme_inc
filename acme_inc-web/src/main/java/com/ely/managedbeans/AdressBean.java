package com.ely.managedbeans;

import java.io.Serializable;
import java.util.List;

import com.ely.entities.Adress;
import com.ely.entities.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ely.services.ACMEAdressServices;

@ManagedBean(name="adressBean")
@SessionScoped

public class AdressBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int selectedUserId;
	private int selectedAdressId;
	private String lastName;
	private String firstName;
	private String adressLine1;
	private String adressLine2;
	private int zipCode;
	private String city;
	private String country;
	private User user;
	
	private List<Adress> getAdressByUserId;
	private List<Adress> getAllAdresses;
	
	@EJB
	ACMEAdressServices acmeadressservices;
	
	
	public void addAdress() {
		Adress adress = new Adress(lastName, firstName,adressLine1, adressLine2, zipCode, city, country, user);
		User selectedUser = new User();
		selectedUser.setId(selectedUserId);
		adress.setUser(selectedUser);
		acmeadressservices.addAdress(adress);
	}
	
	public void modifyAdress(Adress adress) {
		this.setSelectedAdressId(adress.getId());
		this.setLastName(adress.getLastName());
		this.setFirstName(adress.getFirstName());
		this.setAdressLine1(adress.getAdressLine1());
		this.setAdressLine2(adress.getAdressLine2());
		this.setZipCode(adress.getZipCode());
		this.setCity(adress.getCity());
		this.setCountry(adress.getCountry());
		this.setUser(adress.getUser());
	}
	
	public void removeAdress(int adressId) {
		acmeadressservices.deleteAdress(adressId);
	}
	
	public void updateAdress() {
		acmeadressservices.updateAdress(new Adress(selectedAdressId, lastName, firstName, adressLine1, adressLine2, zipCode, city, country, user));
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAdressLine1() {
		return adressLine1;
	}

	public void setAdressLine1(String adressLine1) {
		this.adressLine1 = adressLine1;
	}

	public String getAdressLine2() {
		return adressLine2;
	}

	public void setAdressLine2(String adressLine2) {
		this.adressLine2 = adressLine2;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Adress> getGetAdressByUserId() {
		return getAdressByUserId;
	}

	public void setGetAdressByUserId(List<Adress> getAdressByUserId) {
		this.getAdressByUserId = getAdressByUserId;
	}

	public List<Adress> getGetAllAdresses() {
		getAllAdresses = acmeadressservices.getAllAdresses();
		return getAllAdresses;
	}

	public void setGetAllAdresses(List<Adress> getAllAdresses) {
		this.getAllAdresses = getAllAdresses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

	public int getSelectedAdressId() {
		return selectedAdressId;
	}

	public void setSelectedAdressId(int selectedAdressId) {
		this.selectedAdressId = selectedAdressId;
	}
	
}
