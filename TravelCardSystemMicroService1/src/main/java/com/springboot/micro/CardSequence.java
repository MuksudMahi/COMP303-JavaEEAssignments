package com.springboot.micro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="sequence")
public class CardSequence {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column(name="seq")
	private String seq;
	public CardSequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardSequence(int id, String seq) {
		super();
		this.id = id;
		this.seq = seq;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	
}
