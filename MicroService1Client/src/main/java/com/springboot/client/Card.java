package com.springboot.client;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

//Class to map card entity of microservice
public class Card {
	
	private int cardId;
	private String cardNo;
	@Min(value=1000, message="Pin should be 4-6 digits long")
	@Max(value=999999, message="Pin should be 4-6 digits long")
	private int pin;
	private int custId;
	private String cardType;
	private double price;
	private String status;
	private String renewal;
	private Date cycle;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int pin, int custId, String cardType, double price, String status) {
		super();
		this.pin = pin;
		this.custId = custId;
		this.price = price;
		this.cardType = cardType;
		this.status = status;
	}
	
	//getters and setters
	
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
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
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getRenewal() {
		return renewal;
	}
	public void setRenewal(String renewal) {
		this.renewal = renewal;
	}
	
	public Date getCycle() {
		return cycle;
	}
	public void setCycle(Date cycle) {
		this.cycle = cycle;
	}
	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardNo=" + cardNo + ", pin=" + pin + ", custId=" + custId + ", cardType="
				+ cardType + ", price=" + price + ", status=" + status + "]";
	}
}
