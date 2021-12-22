package com.springboot.micro;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

//card controller to process card adding and updating
@RequestMapping("card")
@RestController
public class CardController {
	@Autowired
	private CardService cs;
	
	@Autowired
	private PassengerService ps;
	
	@Autowired
	CardSequenceRepository cr;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void register(@RequestBody Card card) {
		
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        
		if(card.getRenewal()=="Yearly")
		{
			c.add(Calendar.YEAR, 1);
			card.setCycle(c.getTime());
			
		}
		else
		{
			c.add(Calendar.MONTH, 1);
			card.setCycle(c.getTime());
		}
		
		if(card.getCardType()=="Adult")
		{
			card.setPrice(156);
		}
		else
		{
			card.setPrice(128.15);
		}
		card.setStatus("Active");
		
		CardSequence seq = cr.findById(1).orElseThrow();
		long sequence = Long.parseLong(seq.getSeq())+1;
		card.setCardNo(String.valueOf(sequence));
		seq.setSeq(String.valueOf(sequence));
		cr.save(seq);
		cs.addCard(card);
	}
	
	@RequestMapping(value = "/{custId}", method = RequestMethod.GET)
	public Card passengersCard(@PathVariable("custId") final int custId) {
		Card card = cs.getPassengersCard(custId);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
		if(card!=null && card.getCycle().before(new Date()))
		{
			if(card.getRenewal()=="Yearly")
			{
				c.add(Calendar.YEAR, 1);
				card.setCycle(c.getTime());
			}
			else if(card.getRenewal()=="Monthly")
			{
				c.add(Calendar.MONTH, 1);
				card.setCycle(c.getTime());
			}
			else
			{
				card.setStatus("Expired");
			}
			cs.addCard(card);
		}
		return card;
	}
	
	@RequestMapping(value = "auth/{cardNo}&{pin}", method = RequestMethod.GET)
	public Card auth(@PathVariable("cardNo") final String cardNo, @PathVariable("pin") final int pin) {
		System.out.println("Details:" +cardNo +" "+ pin);
		return cs.getCard(cardNo, pin);
	}
}
