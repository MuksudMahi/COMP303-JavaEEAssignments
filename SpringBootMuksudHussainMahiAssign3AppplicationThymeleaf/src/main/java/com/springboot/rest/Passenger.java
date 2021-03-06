package com.springboot.rest;

public class Passenger {
	private int passengerId;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String city;
	private String phone;
	private String email;
	
	
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(int passengerId, String firstName, String lastName, int age, String address, String city,
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
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
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
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", address=" + address + ", city=" + city + ", phone=" + phone + ", email=" + email
				+ "]";
	}
	
	
	
}
