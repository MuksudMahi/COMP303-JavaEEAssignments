package com.springboot.micro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//card jpa repository
public interface CardRepository extends JpaRepository<Card, Integer> {
	
	//query for process login
	@Query("select u from Card u where u.cardNo=?1 and u.pin=?2")
	Card findByCardNoAndPin(String cardNo, int pin);
	
	@Query("select u from Card u where u.custId=?1")
	Card findByCustId(int custId);
}
