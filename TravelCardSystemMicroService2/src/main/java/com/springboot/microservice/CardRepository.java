package com.springboot.microservice;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, String> {
	Mono<Card> findByCustId(String custId);
	Mono<Card> findByCardNoAndPin(String cardNo, int pin);
}
