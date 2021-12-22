package com.springboot.micro;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
//processing passenger update and delete request
@RequestMapping("passenger")
@RestController
public class PassengerController {
	@Autowired
	private PassengerService ps;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Passenger register(@RequestBody Passenger passenger) {
		if(ps.getPassengerByEmail(passenger.getEmail())==null)
		{
			ps.addPassenger(passenger);
			return ps.getPassengerByEmail(passenger.getEmail());
		}
		else
			return new Passenger();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<Passenger> getAllPassenger() {
		return ps.getPassengers();
	}
	
	@RequestMapping(value = "/{email}&{password}", method = RequestMethod.GET)
	public Passenger login(@PathVariable("email") final String email,
			@PathVariable("password") final String password) {
		Passenger p = ps.getPassenger(email, password);
		if(p != null)
			return p;
		else 
			return null;
	}
}
