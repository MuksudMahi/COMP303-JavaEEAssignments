package com.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
	
	
	
	@Autowired
	CardService cardService;
	
	@ResponseBody
	@RequestMapping
	public String Home()
	{
		return "Working";
	}
	
	//
	@RequestMapping(value = "/{cardNo}", method = RequestMethod.GET)
	Card getCard(@PathVariable("cardNo") int cardNo) throws Exception {
		return cardService.getCard(cardNo);
	}

	//
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    Iterable<Card> getCards()
    {
    	return cardService.getCards();
    }

	//
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addCard(@RequestBody Card card) throws Exception
    {
		cardService.addCard(card);
    }
    
	//
	@RequestMapping(value="/{cardNo}&{price}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	void updateCard(@PathVariable("cardNo") int cardNo, @RequestBody Card card) throws Exception
	{
		card.setCardNo(cardNo);
		cardService.updateCard(card);
	}
	
	//
	@RequestMapping(value="/{cardNo}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	void deleteCard(@PathVariable("cardNo")int cardNo) throws Exception
	{
		cardService.deleteCard(cardNo);
	}
}
