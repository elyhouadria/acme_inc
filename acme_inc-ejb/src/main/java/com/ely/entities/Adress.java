package com.ely.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Adress implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String lastName;
	private String firstName;
	private String adressLine1;
	private String adressLine2;
	private int zipCode;
	private String city;
	private String country;
	
	@ManyToOne
	@JoinColumn(name="fk_userid")
	private User user;
	
	@OneToMany(mappedBy="adress")
	private List<UserOrder> userOrdersAdress;

	public Adress() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserOrder> getuserOrdersAdress() {
		return userOrdersAdress;
	}

	public void setOrdersAdress(List<UserOrder> userOrdersAdress) {
		this.userOrdersAdress = userOrdersAdress;
	}

	public Adress(String lastName, String firstName, String adressLine1, String adressLine2, int zipCode, String city,
			String country) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.adressLine1 = adressLine1;
		this.adressLine2 = adressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public Adress(String lastName, String firstName, String adressLine1, String adressLine2, int zipCode, String city, String country, User user) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.adressLine1 = adressLine1;
		this.adressLine2 = adressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.user = user;
		}

	public Adress(int id, String lastName, String firstName, String adressLine1, String adressLine2, int zipCode, String city, String country, User user) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.adressLine1 = adressLine1;
		this.adressLine2 = adressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.user = user;
		
	}

	@Override
	public String toString() {
//		return id + ", " + lastName + ", " + firstName + ", " + adressLine1 + ", " + adressLine2 + ", " + zipCode + ", " + city	+ ", " + country;
		return String.valueOf(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
