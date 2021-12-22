package com.springboot.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
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
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getPassenger(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		String id=request.getParameter("id");
		Passenger passenger=passengerService.getPassenger(Integer.parseInt(id));
		model.addAttribute("passenger", passenger);
		return "updatePassenger";
	}
	//
	@RequestMapping(value = "/{passengerId}", method = RequestMethod.GET)
	public String getPassenger(@PathVariable("passengerId") int passengerId, Model model) throws Exception {
		Passenger passenger=passengerService.getPassenger(passengerId);
		model.addAttribute("passenger", passenger);
		return "updatePassenger";
	}

	//
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getPassengers(Model model)
    {
		Iterable<Passenger> passengers = passengerService.getPassengers();
		model.addAttribute("passengers", passengers);
		return "allPassengers";
    }
	
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
    //@ResponseStatus(value = HttpStatus.OK)
    public String addPassengerForm(Model model)
    {
		Passenger passenger = new Passenger();
		model.addAttribute("passenger", passenger);
		return "addPassenger";
    }
	
	//
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addPassenger(Passenger passenger) throws Exception
    {
		passengerService.addPassenger(passenger);
		System.out.println(passenger);
		return "index";
    }
    
	//
	@RequestMapping(value="/{passengerId}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String updatePassenger(@PathVariable("passengerId") String passengerId, Passenger passenger) throws Exception
	{
		passenger.setPassengerId(Integer.parseInt(passengerId));
		passengerService.updatePassenger(passenger);
		return "index";
	}
	
	//
	@RequestMapping(value="/delete/{passengerId}", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public String deletePassenger(@PathVariable("passengerId")int passengerId) throws Exception
	{
		passengerService.deletePassenger(passengerId);
		return "index";
	}
}
