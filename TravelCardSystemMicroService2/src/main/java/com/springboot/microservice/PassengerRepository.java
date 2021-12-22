package com.springboot.microservice;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface PassengerRepository extends ReactiveMongoRepository<Passenger, String>{
	Mono<Passenger> findByEmailAndPassword(String email, String password);
	Mono<Passenger> findByEmail(String email);
}
