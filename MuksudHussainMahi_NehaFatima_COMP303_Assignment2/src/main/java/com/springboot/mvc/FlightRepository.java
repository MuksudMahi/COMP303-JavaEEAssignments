/*
 * Authors:
 * Muksud Hussain Mahi (301155894)
 * Neha Fatima (301179066)
 */
package com.springboot.mvc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	/*
	 * get flight by flight code
	 */
	@Query("select u from Flight u join u.reservation r where r.flightCode=?1")
	Flight findByReservationId(int flightCode);
	
	/*
	 * Update flight data
	 */
	@Transactional
	@Modifying
	@Query("update Flight f set f.departure=?1, f.arrival=?2 where f.flightCode=?3")
	void updateFlight(String departure, String arrival, int id);
}
