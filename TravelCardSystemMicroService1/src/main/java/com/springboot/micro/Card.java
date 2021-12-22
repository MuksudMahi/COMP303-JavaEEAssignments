package com.springboot.micro;

import java.util.Date;

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
//card entity
@Entity
@Table(name="card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int cardId;
	@Column(name="cardno")
	private String cardNo;
	@Column(name="pin")
	private int pin;
	@Column(name="custid")
	private int custId;
	@Column(name="cardtype")
	private String cardType;
	@Column(name="price")
	private double price;
	@Column(name="status")
	private String status;
	@Column(name="renewal")
	private String renewal;
	@Column(name="cycle")
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
