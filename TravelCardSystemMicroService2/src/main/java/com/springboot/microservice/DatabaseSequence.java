package com.springboot.microservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sequence")
public class DatabaseSequence {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
	@Column(name="seq")
    private String seq;
    
	public DatabaseSequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
}
