package com.springboot.microservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	public Flux<Passenger>getPassengers()
	{
		return passengerRepo.findAll().switchIfEmpty(Flux.empty());
	}
	
	public Mono<Passenger> addPassenger(Passenger passenger)
	{
		//System.out.println(passenger);

		return passengerRepo.save(passenger);
	}
	
    public Mono<Passenger> getPassenger(String email, String password)
    {
    	return passengerRepo.findByEmailAndPassword(email, password);
    }
    
    public Mono<Passenger> getPassengerbyEmail(String email)
    {
    	return passengerRepo.findByEmail(email);
    }
    
    public Mono<Passenger> getPassengerById(String passengerId)
    {
    	return passengerRepo.findById(passengerId);
    }
}
