/*
 * Authors:
 * Muksud Hussain Mahi (301155894)
 * Neha Fatima (301179066)
 */
package com.springboot.mvc;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="passengers")
public class Passenger {

	/*
	 * Passenger class refers to the passenger table in the database
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="custid")
	private int custId;
	@Column(name="email")
	@NotEmpty
	private String email;
	@Column(name="pass")
	@Size(min=6, max=8)  
	private String password;
	@Column(name="firstname")
	@NotEmpty
	private String firstName;
	@Column(name="lastname")
	@NotEmpty
	private String lastName;
	@Column(name="phonenumber")
	@NotEmpty
	private String phoneNumber;
	@Column(name="address")
	@NotEmpty
	private String address;
	@Column(name="city")
	@NotEmpty
	private String city;
	@Column(name="postalcode")
	@NotEmpty
	private String postalCode;
	@Column(name="country")
	@NotEmpty
	private String country;
	
	
	   //relationship with reservation table
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "custid",referencedColumnName="custId")
	private List<Reservation> reservationList = new ArrayList<>();
	 
	
	
	/*
	 * Getters and setters
	 */
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
	public List<Reservation> getReservationList() { return reservationList; }
	public void setReservationList(List<Reservation> reservationList) {
	this.reservationList = reservationList; }
	 
	@Override
	public String toString() {
		return "Passenger [custId=" + custId + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", city=" + city + ", postalCode=" + postalCode + ", country=" + country + "]";
	}
	
	
}