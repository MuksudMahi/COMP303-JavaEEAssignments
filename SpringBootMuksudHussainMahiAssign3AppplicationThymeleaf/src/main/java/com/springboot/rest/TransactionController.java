package com.springboot.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@Controller
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
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String searchTransaction(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		String id=request.getParameter("id");
		Transaction transaction = transactionService.getTransaction(Integer.parseInt(id));
		model.addAttribute("transactions", transaction);
		return "allTransactions";
	}
	//
	@RequestMapping(value = "/{cardNo}", method = RequestMethod.GET)
	Transaction getTransaction(@PathVariable("cardNo") int cardNo) throws Exception {
		return transactionService.getTransaction(cardNo);
	}

	//
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getTransactions(Model model)
    {
    	Iterable<Transaction>transactions= transactionService.getTransactions();
    	model.addAttribute("transactions", transactions);
    	return "allTransactions";
    }
	
	//
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTransactionForm(Model model) throws Exception
    {
		Transaction transaction= new Transaction();
		model.addAttribute("transaction", transaction);
		return "addTransaction";
    }

	//
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addTransaction(Transaction transaction) throws Exception
    {
		transactionService.addTransaction(transaction);
		return "index";
    }
    
	//
	@RequestMapping(value="/new/{cardNo}", method=RequestMethod.GET )
	@ResponseStatus(value=HttpStatus.OK)
	public String newTransactionForm(@PathVariable("cardNo") int cardNo, Model model) throws Exception
	{
		Transaction transaction = transactionService.getTransaction(cardNo);
		model.addAttribute("transaction", transaction);
		return "newTransaction";
	}
	
	//
	@RequestMapping(value="/new/{cardNo}", method=RequestMethod.POST )
	@ResponseStatus(value=HttpStatus.OK)
	public String updateTransaction(@PathVariable("cardNo") int cardNo, HttpServletRequest request,HttpServletResponse response, Model model) throws Exception
	{
		String price = request.getParameter("Price");
		Transaction transaction = transactionService.getTransaction(cardNo);
		transaction.setBalance(transaction.getBalance()-Double.parseDouble(price));
		transactionService.updateTransaction(transaction);
    	Iterable<Transaction>transactions= transactionService.getTransactions();
    	model.addAttribute("transactions", transactions);
		
		return "allTransactions";
	}
	
	//
	@RequestMapping(value="/delete/{cardNo}", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public String deletePassenger(@PathVariable("cardNo")int cardNo) throws Exception
	{
		transactionService.deleteTransaction(cardNo);
		return "index";
	}
}
