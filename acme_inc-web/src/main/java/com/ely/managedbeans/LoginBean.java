package com.ely.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ely.entities.User;
import com.ely.interfaces.ACMEUserServicesRemote;


@ManagedBean(name="loginBean")
@SessionScoped

public class LoginBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private User user;
	private Boolean loggedIn;
	
	@EJB
	ACMEUserServicesRemote acmeUserServicesRemote;
	
	public String doLogin() {
		String navigateTo = "null";
		user = acmeUserServicesRemote.getUserByEmailAndPassword(email, password);
		if (user != null) {
			navigateTo = "/pages/welcome?faces-redirect=true";
			loggedIn = true;
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo;
	}
	
	public String doLogout() {
		String navigateTo = "/pages/homepage?faces-redirect=true";
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return navigateTo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
