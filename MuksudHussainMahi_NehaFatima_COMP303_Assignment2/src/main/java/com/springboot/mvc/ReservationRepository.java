/*
 * Authors:
 * Muksud Hussain Mahi (301155894)
 * Neha Fatima (301179066)
 */
package com.springboot.mvc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	//query to get reservation by customer id
	@Query("select u from Reservation u where u.custId=?1")
	List<Reservation> findByCustId(int custid);
}
