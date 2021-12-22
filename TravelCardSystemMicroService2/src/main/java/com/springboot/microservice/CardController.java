package com.springboot.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RequestMapping("card")
@AllArgsConstructor
@RestController
public class CardController {
	@Autowired
	private CardService cs;
	
	@Autowired
	private PassengerService ps;
	
	
	@Autowired
	private SequenceRepository cr;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Mono<Card> register(@RequestBody Card card) {
		DatabaseSequence seq = cr.findById(1).orElseThrow();
		long sequence = Long.parseLong(seq.getSeq())+1;
		card.setCardNo(String.valueOf(sequence));
		seq.setSeq(String.valueOf(sequence));
		cr.save(seq);
		return cs.addCard(card);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Mono<Card> update(@RequestBody Card card) {
		return cs.addCard(card);
	}
	
	@RequestMapping(value = "/{custId}", method = RequestMethod.GET)
	public Mono<Card> passengersCard(@PathVariable("custId") final String custId) {
		return cs.getPassengersCard(custId);
	}
	
	@RequestMapping(value = "auth/{cardNo}&{pin}", method = RequestMethod.GET)
	public Mono<Card> auth(@PathVariable("cardNo") final String cardNo, @PathVariable("pin") final String pin) {
		System.out.println("Details:" +cardNo +" "+ pin);
		return cs.auth(cardNo, Integer.parseInt(pin));
	}
	
	@RequestMapping(value = "/transaction/{cardNo}", method = RequestMethod.PUT)
	public Mono<Card> transaction(@PathVariable("cardNo") final String cardNo) {
		Card card = cs.getCard(cardNo).block();
		Passenger passenger = ps.getPassengerById(card.getCustId()).block();
		
		int age = passenger.getAge();
		if((age >= 20 && age <= 64))
		{
			card.setBalance(card.getBalance()-3.25);
		}
		
		else
		{
			card.setBalance(card.getBalance()-2.30);
		}
		
		return cs.transaction(card);
		
	}
	
	@RequestMapping(value = "topup/{cardNo}&{price}", method = RequestMethod.PUT)
	public Mono<Card> topup(@PathVariable("cardNo") final String cardNo, @PathVariable("price") final String price) {
		Card card = cs.getCard(cardNo).block();
		card.setPrice(Double.parseDouble(price));
		card.setBalance(card.getBalance()+Double.parseDouble(price));
		return cs.updateCard(card);
	}
	
}
