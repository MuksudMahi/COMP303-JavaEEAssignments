/*
 * Authors:
 * Muksud Hussain Mahi (301155894)
 * Neha Fatima (301179066)
 */
package com.springboot.mvc;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	
	//query for process login
	@Query("select u from Passenger u where u.email=?1 and u.password=?2")
	Passenger findByEmailAndPassword(String email, String password );
	
	//query to get user by email to prevent same user registration
	@Query("select u from Passenger u where u.email=?1")
	Passenger findByEmail(String email);
	
	/*
	 * Update passenger data
	 */
	@Transactional
	@Modifying
	@Query("update Passenger f set f.phoneNumber=?1, f.address=?2, f.city=?3, f.postalCode=?4 where f.custId=?5")
	void updatePassenger(String phone, String address, String city, String postal, int id);
}