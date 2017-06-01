package com.niit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "User")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

//	@NotEmpty(message = "name  is required")
	private String name;

//	@NotEmpty(message = "pssword  is required")
	private String password;

	@Column(name = "role")
	private String role;

	//@NotEmpty(message = "contact  is required")
//	private String contact;

	//@NotEmpty(message = "email  is required")
//	private String email;

	@OneToOne(mappedBy = "user")
	private Customer customer;

	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//public String getEmail() {
	//	return email;
//	}

//	public void setEmail(String email) {
	//	this.email = email;
	//}
//
//	public String getContact() {
//		return contact;
	//}

//	public void setContact(String contact) {
//		this.contact = contact;
//	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// getters + setters

}
