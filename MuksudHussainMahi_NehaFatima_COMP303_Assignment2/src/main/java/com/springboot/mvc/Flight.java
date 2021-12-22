/*
 * Authors:
 * Muksud Hussain Mahi (301155894)
 * Neha Fatima (301179066)
 */
package com.springboot.mvc;

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

@Entity
@Table(name="flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="flightcode")
	private int flightCode;
	@Column(name="departure")
	private String departure;
	@Column(name="arrival")
	private String arrival;
	@Column(name="departurecity")
	private String departurCity;
	@Column(name="destination")
	private String destination;
	@Column(name="airlinename")
	private String airlineName;
	@Column(name="fare")
	private String fare;
	@Column(name="price")
	private double price;
	
	
	/*
	 * Relationship with reservation table
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) 
	@JoinColumn(name = "flightcode",referencedColumnName="flightcode")
	private Reservation reservation;
	 
	 
	
	
	
	public Flight() {
		super();
	}
	

	public Flight(String departure, String arrival, String departurCity, String destination, String airlineName,
			String fare, double price) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.departurCity = departurCity;
		this.destination = destination;
		this.airlineName = airlineName;
		this.fare = fare;
		this.price = price;
	}


	/*
	 * getters and setters
	 */

	public int getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(int flightCode) {
		this.flightCode = flightCode;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	  public String getDeparture() {
		return departure;
	}


	public void setDeparture(String departure) {
		this.departure = departure;
	}


	public String getArrival() {
		return arrival;
	}


	public void setArrival(String arrival) {
		this.arrival = arrival;
	}


	public String getDeparturCity() {
		return departurCity;
	}


	public void setDeparturCity(String departurCity) {
		this.departurCity = departurCity;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Reservation getReservation() { return reservation; } 
	  public void setReservation(Reservation reservation) { this.reservation = reservation; }

	  /*
	   * toString to test values
	   */

	@Override
	public String toString() {
		return "Flight [flightCode=" + flightCode + ", departure=" + departure + ", arrival=" + arrival
				+ ", departurCity=" + departurCity + ", destination=" + destination + ", airlineName=" + airlineName
				+ ", fare=" + fare + ", price=" + price + ", reservation=" + reservation + "]";
	}
	 
	 

	
	
}
