package com.springboot.client;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//class to map card  entity
public class Card {
	private String cardNo;
	@Min(value=1000, message="Pin should be 4-6 digits long")
	@Max(value=999999, message="Pin should be 4-6 digits long")
	private int pin;
	private String custId;
	private double price;
	private double balance;
	private String transDate;
	private String status;
	
	
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int pin, String custId, double price, double balance, String transDate, String status) {
		super();
		this.pin = pin;
		this.custId = custId;
		this.price = price;
		this.balance = balance;
		this.transDate = transDate;
		this.status = status;
	}
		
	//getters and setters
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", pin=" + pin + ", custId=" + custId + ", price=" + price + ", balance="
				+ balance + ", transDate=" + transDate + ", Status=" + status + "]";
	}
	
}
