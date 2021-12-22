package com.springboot.client;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//class to map passenger entity
public class Passenger {
	
	private String passengerId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	@NotNull(message="Enter phone")
	@Pattern(regexp ="^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$", 
			message="Enter correct phone number")
	private String phone;
	@NotNull(message="Enter email")
	@Email(message="Enter a valid email")
	private String email;
	@NotNull(message="Enter Age")
	@Min(value=10, message="Age should be minimum 10")
	private int age;
	@NotNull(message="Enter password")
	@Size(min=6, max=8, message="Password should be 6-8 charecter long")
	private String password;
	
	
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String passengerId, String firstName, String lastName, int age, String address, String city,
			String phone, String email) {
		super();
		this.passengerId = passengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.email = email;
	}

	//getter an setter
	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
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
		return "Passenger [passengerId=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", address=" + address + ", city=" + city + ", phone=" + phone + ", email=" + email
				+ "]";
	}
	
	
}
