package com.springboot.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	Map<Integer, Transaction> transactions = new HashMap<>();

    public void addTransaction(Transaction transaction) throws Exception {
        if(transactions.containsKey(transaction.getCardNo())) {
            throw new Exception("This transaction already exists");
        }
        else {
            transactions.put(transaction.getCardNo(), transaction);
        }
    }

    public Iterable<Transaction> getTransactions(){
        return transactions.values();
    }

    public Transaction getTransaction(int cardNo) throws Exception {

        if(transactions.containsKey(cardNo)) {
            return transactions.get(cardNo);
        }
        else {
            throw new Exception("Transaction not found");
        }
    }

    public void updateTransaction(Transaction transaction) throws Exception {
        if(transactions.containsKey(transaction.getCardNo())) {
            transactions.put(transaction.getCardNo(), transaction);
        }
        else {
            throw new Exception("Transaction Id not found");
        }
    }

    public void deleteTransaction(int cardNo) throws Exception {
        if(transactions.containsKey(cardNo)) {
            transactions.remove(cardNo);
        }
        else {
            throw new Exception("Transaction not found");
        }
    }
}
