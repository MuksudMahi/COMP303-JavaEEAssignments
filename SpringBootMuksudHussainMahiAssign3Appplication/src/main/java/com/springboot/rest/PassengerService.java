package com.springboot.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PassengerService {
	Map<Integer,Passenger>passengers=new HashMap<>();
	
	public void addPassenger(Passenger passenger) throws Exception
	{
		if(passengers.containsKey(passenger.getPassengerId()))
		{
			throw new Exception("Passenger already exists!!!");
		}
		else
		{
			passengers.put(passenger.getPassengerId(), passenger);
		}
	}
	
	public Iterable<Passenger>getPassengers()
	{
		return passengers.values();
	}
	
    public Passenger getPassenger(int passengerId) throws Exception {

        if(passengers.containsKey(passengerId)) {
            return passengers.get(passengerId);
        }
        else {
            throw new Exception("Passenger not found");
        }
    }

    public void updatePassenger(Passenger passenger) throws Exception {
        if(passengers.containsKey(passenger.getPassengerId())) {
            passengers.put(passenger.getPassengerId(), passenger);
        }
        else {
            throw new Exception("Passenger not found");
        }
    }

    public void deletePassenger(int passengerId) throws Exception {
        if(passengers.containsKey(passengerId)) {
            passengers.remove(passengerId);
        }
        else {
            throw new Exception("Passenger not found");
        }
    }
}
