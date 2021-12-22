package com.springboot.microservice;

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
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("passenger")
@AllArgsConstructor
@RestController
public class PassengerController {
	@Autowired
	private PassengerService ps;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Mono<Passenger> register(@RequestBody Passenger passenger) {
		if(ps.getPassengerbyEmail(passenger.getEmail())==null)
			return ps.addPassenger(passenger);
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Flux<Passenger> getAllPassenger() {
		return ps.getPassengers();
	}
	@RequestMapping(value = "/{email}&{password}", method = RequestMethod.GET)
	public Mono<Passenger> login(@PathVariable("email") final String email,
			@PathVariable("password") final String password) {
		Mono<Passenger> p = ps.getPassenger(email, password);
		if(p.block()==null)
			return null;
		else
			return p;
	}
}
