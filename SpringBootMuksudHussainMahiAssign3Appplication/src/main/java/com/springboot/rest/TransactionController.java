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
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@ResponseBody
	@RequestMapping
	public String Home()
	{
		return "Working";
	}
	
	//
	@RequestMapping(value = "/{cardNo}", method = RequestMethod.GET)
	Transaction getTransaction(@PathVariable("cardNo") int cardNo) throws Exception {
		return transactionService.getTransaction(cardNo);
	}

	//
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    Iterable<Transaction> getTransactions()
    {
    	return transactionService.getTransactions();
    }

	//
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addTransaction(@RequestBody Transaction transaction) throws Exception
    {
		transactionService.addTransaction(transaction);
    }
    
	//
	@RequestMapping(value="/{cardNo}&{price}", method=RequestMethod.PUT )
	@ResponseStatus(value=HttpStatus.OK)
	void updateTransaction(@PathVariable("cardNo") int cardNo,@PathVariable("price") double price) throws Exception
	{
		Transaction transaction = transactionService.getTransaction(cardNo);
		transaction.setBalance(transaction.getBalance()-price);
		transactionService.updateTransaction(transaction);
	}
	
	//
	@RequestMapping(value="/{cardNo}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	void deletePassenger(@PathVariable("cardNo")int cardNo) throws Exception
	{
		transactionService.deleteTransaction(cardNo);
	}
}
