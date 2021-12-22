package com.springboot.micro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	 public Iterable<Passenger>getPassengers() { 
		 return passengerRepo.findAll(); 
	 }
	 public void addPassenger(Passenger passenger) {
	 //System.out.println(passenger); 
		 passengerRepo.save(passenger); 
	 }
	 
	 public Passenger getPassenger(String email, String password) { 
		 
		 return passengerRepo.findByEmailAndPassword(email, password); 
		 
	 }
	 
	 public Passenger getPassengerByEmail(String email) { 
		 
		 return passengerRepo.findByEmail(email); 
		 
	 }
}
