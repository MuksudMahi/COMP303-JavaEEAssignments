package com.springboot.micro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{
	
	//query for process login
	@Query("select u from Passenger u where u.email=?1 and u.password=?2")
	Passenger findByEmailAndPassword(String email, String password );
	
	//query for process login
	@Query("select u from Passenger u where u.email=?1")
	Passenger findByEmail(String email);
}
