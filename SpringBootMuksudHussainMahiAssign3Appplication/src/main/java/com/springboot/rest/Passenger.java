package com.springboot.rest;

public class Passenger {
	private int PassengerId;
	private String FirstName;
	private String LastName;
	private String Age;
	private String Address;
	private String City;
	private String Phone;
	private String Email;
	
	
	
	public Passenger(int passengerId, String firstName, String lastName, String age, String address, String city,
			String phone, String email) {
		super();
		PassengerId = passengerId;
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		Address = address;
		City = city;
		Phone = phone;
		Email = email;
	}
	
	
	
	public int getPassengerId() {
		return PassengerId;
	}



	public void setPassengerId(int passengerId) {
		PassengerId = passengerId;
	}



	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Passenger [FirstName=" + FirstName + ", LastName=" + LastName + ", Age=" + Age + ", Address=" + Address
				+ ", City=" + City + ", Phone=" + Phone + ", Email=" + Email + "]";
	}
	
}
