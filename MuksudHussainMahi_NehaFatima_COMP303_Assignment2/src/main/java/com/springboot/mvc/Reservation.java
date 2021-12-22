/*
 * Authors:
 * Muksud Hussain Mahi (301155894)
 * Neha Fatima (301179066)
 */
package com.springboot.mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="reservationid")
	private int reservationid;
	@Column(name="custid")
	private int custId;
	@Column(name="flightcode")
	private int flightCode;
	@Column(name="totalpassenger")
	private int totalPassenger;
	@Column(name="amountpaid")
	private double amountPaid;
	@Column(name="reservationdate")
	private String reservationDate;
	
	public Reservation()
	{
		
	}
	public Reservation(int custId, int flightCode, int totalPassenger, double amountPaid, String reservationDate) {
		super();
		this.custId = custId;
		this.flightCode = flightCode;
		this.totalPassenger = totalPassenger;
		this.amountPaid = amountPaid;
		this.reservationDate = reservationDate;
	}
	
	/*
	 * getters and setters
	 */
	public int getReservationid() {
		return reservationid;
	}
	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(int flightCode) {
		this.flightCode = flightCode;
	}
	public int getTotalPassenger() {
		return totalPassenger;
	}
	public void setTotalPassenger(int totalPassenger) {
		this.totalPassenger = totalPassenger;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	@Override
	public String toString() {
		return "Reservation [reservationid=" + reservationid + ", custId=" + custId + ", flightCode=" + flightCode
				+ ", totalPassenger=" + totalPassenger + ", amountPaid=" + amountPaid + ", reservationDate="
				+ reservationDate + "]";
	}
	
}
