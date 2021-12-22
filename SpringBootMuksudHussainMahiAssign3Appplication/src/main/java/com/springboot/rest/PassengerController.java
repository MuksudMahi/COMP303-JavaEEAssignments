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
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	PassengerService passengerService;

	//
	@ResponseBody
	@RequestMapping
	public String Home() {
		return "Working";
	}

	//
	@RequestMapping(value = "/{passengerId}", method = RequestMethod.GET)
	Passenger getPassenger(@PathVariable("passengerId") int passengerId) throws Exception {
		return passengerService.getPassenger(passengerId);
	}

	//
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    Iterable<Passenger> getPassengers()
    {
    	return passengerService.getPassengers();
    }

	//
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addPassenger(@RequestBody Passenger passenger) throws Exception
    {
		passengerService.addPassenger(passenger);
    }
    
	//
	@RequestMapping(value="/{passengerId}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	void updatePassenger(@PathVariable("passengerId") int passengerId, @RequestBody Passenger passenger) throws Exception
	{
		passenger.setPassengerId(passengerId);
		passengerService.updatePassenger(passenger);
	}
	
	//
	@RequestMapping(value="/{passengerId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	void deletePassenger(@PathVariable("passengerId")int passengerId) throws Exception
	{
		passengerService.deletePassenger(passengerId);
	}
}
