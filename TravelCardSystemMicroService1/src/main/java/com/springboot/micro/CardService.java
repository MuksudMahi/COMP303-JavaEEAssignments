package com.springboot.micro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class CardService {
	@Autowired
	private CardRepository cardRepo;
	
	 public void addCard(Card card) { 
		 cardRepo.save(card); 
		 }
	  
	 public Card getCard(String cardNo, int pin) { 
		 return cardRepo.findByCardNoAndPin(cardNo, pin);
	 } 
	 public Card getPassengersCard(int custId) {
		 return cardRepo.findByCustId(custId);
		 //return null;
		 }
	 /* public Mono<Card> updateCard(Card card) { return cardRepo.save(card); }
	 * 
	 * public Mono<Card> auth(String cardNo, int pin) { return
	 * cardRepo.findByCardNoAndPin(cardNo, pin); }
	 * 
	 * public Mono<Card> transaction(Card card) { return cardRepo.save(card); }
	 */
}
