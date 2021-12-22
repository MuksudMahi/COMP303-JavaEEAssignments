package com.springboot.micro;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//passenger entity class
@Entity
@Table(name="customer")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="custid")
	private int custId;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="age")
	private int age;
	@Column(name="password")
	private String password;
	
	
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String firstName, String lastName, int age, String address, String city,
			String phone, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) 
	@JoinColumn(name = "custid",referencedColumnName="custid")
	private Card card;
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@Override
	public String toString() {
		return "Passenger [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", address=" + address + ", city=" + city + ", phone=" + phone + ", email=" + email
				+ "]";
	}
	
	
}
