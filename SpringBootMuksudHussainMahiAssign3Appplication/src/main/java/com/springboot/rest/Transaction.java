package com.springboot.rest;

public class Transaction {
	private int CardNo;
	private double Price;
	private double Balance;
	private String TransDate;
	
	public Transaction(int cardNo, double price, double balance, String transDate) {
		super();
		CardNo = cardNo;
		Price = price;
		Balance = balance;
		TransDate = transDate;
	}
	public int getCardNo() {
		return CardNo;
	}
	public void setCardNo(int cardNo) {
		CardNo = cardNo;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public String getTransDate() {
		return TransDate;
	}
	public void setTransDate(String transDate) {
		TransDate = transDate;
	}
	@Override
	public String toString() {
		return "Transaction [CardNo=" + CardNo + ", Price=" + Price + ", Balance=" + Balance + ", TransDate="
				+ TransDate + "]";
	}
	
	
}
