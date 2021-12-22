package com.springboot.microservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class CardService {
	@Autowired
	private CardRepository cardRepo;
	
	public Flux<Card>getCards()
	{
		return cardRepo.findAll().switchIfEmpty(Flux.empty());
	}
	
	public Mono<Card> addCard(Card card)
	{
		return cardRepo.save(card);
	}
	
    public Mono<Card> getCard(String cardNo)
    {
    	return cardRepo.findById(cardNo);
    }
    
    public Mono<Card> getPassengersCard(String custId)
    {
    	 return cardRepo.findByCustId(custId);
    }
    
	public Mono<Card> updateCard(Card card)
	{
		return cardRepo.save(card);
	}
	
	public Mono<Card> auth(String cardNo, int pin)
	{
		return cardRepo.findByCardNoAndPin(cardNo, pin);
	}
	
	public Mono<Card> transaction(Card card)
	{
		return cardRepo.save(card);
	}
}
