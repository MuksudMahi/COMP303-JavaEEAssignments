package com.springboot.rest;

public class Card {
	
	private int CardNo;
	private int Pin;
	private String Status;
	private String ManufacturedDate;
	
	
	
	public Card(int cardNo, int pin, String status, String manufacturedDate) {
		super();
		CardNo = cardNo;
		Pin = pin;
		Status = status;
		ManufacturedDate = manufacturedDate;
	}
	public int getCardNo() {
		return CardNo;
	}
	public void setCardNo(int cardNo) {
		CardNo = cardNo;
	}
	public int getPin() {
		return Pin;
	}
	public void setPin(int pin) {
		Pin = pin;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getManufacturedDate() {
		return ManufacturedDate;
	}
	public void setManufacturedDate(String manufacturedDate) {
		ManufacturedDate = manufacturedDate;
	}
	@Override
	public String toString() {
		return "Card [CardNo=" + CardNo + ", Pin=" + Pin + ", Status=" + Status + ", ManufacturedDate="
				+ ManufacturedDate + "]";
	}
}
