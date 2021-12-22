/*
 * Authors:
 * Muksud Hussain Mahi (301155894)
 * Neha Fatima (301179066)
 */

package com.springboot.mvc;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

	@Autowired
	private FlightRepository fr;
	
	@Autowired
	private ReservationRepository rr;
	
	@Autowired
	private PassengerRepository auth;
	
	private Passenger passenger;
	private Reservation reservation;
	private Flight flight;
	int totalPassenger;
	double totalCost;
	
	@RequestMapping("/")
	//method to process home url
	public String home(Model model)
	{
		if(passenger!=null)
		{
	    	model.addAttribute("user", passenger);
		}
		model.addAttribute("title", "Home");
		return "home";
	}
	
	@PostMapping("/login")  
	  //method to process login request
	public String getLogin(HttpServletRequest request,HttpServletResponse response, Model model) {
		String email=request.getParameter("email");  
	    String password=request.getParameter("password");
	    
	    passenger = auth.findByEmailAndPassword(email, password);
	    if(passenger!=null)
	    	{
	    		model.addAttribute("title", "Book Flight");
		    	model.addAttribute("user", passenger);
	    		return "bookFlight";
	    	}
	    else
	    {
	    	model.addAttribute("message", "Invalid email/password");
	    	return "login";
	    }
	}
	
	@PostMapping("/register-user")  
	  //method to process register request
	public String registerUser(@Valid @ModelAttribute("objPassenger") Passenger p, BindingResult br, Model model) {
	    
		if(br.hasErrors())
		{
	    	model.addAttribute("message", "Please fill up all the fields");
	    	return "register";
		}
		else if(auth.findByEmail(p.getEmail())!=null)
		{
	    	model.addAttribute("message", "User alrady exists");
	    	return "register";
		}
		else
		{
			auth.save(p);
			passenger=p;
    		model.addAttribute("title", "Book Flight");
	    	model.addAttribute("user", p);
    		return "bookFlight";
		}
	}
	
	
	@RequestMapping("/signin")
	//method to process login request 
	public String login(Model model)
	{		
		if(passenger!=null)
		{
			model.addAttribute("user", passenger);
				return "home";
    	}
		model.addAttribute("title", "Login");
		return "login";
	}
	
	@RequestMapping("/logout")
	//method to process logout
	public String logout(Model model)
	{
		passenger=null;
		model.addAttribute("title", "Home");
		return "home";
	}
	
	@RequestMapping("/register")
	//method to process register
	public String register(Model model)
	{
		if(passenger!=null)
		{
	    	model.addAttribute("user", passenger);
		}
		model.addAttribute("objPassenger", new Passenger());
		//model.addAttribute("title", "Home");
		return "register";
	}
	
	@RequestMapping("/book-flight")
	//method to process flight booking
	public String book(Model model)
	{
		if(passenger!=null)
		{
			model.addAttribute("title", "Book Flight");
	    	model.addAttribute("user", passenger);
			return "bookFlight";
		}
		else
		{
			model.addAttribute("title", "Login");
			return "login";
		}
	}
	
	@PostMapping("/reserve")  
	  //method to save flight booking
	public String bookFlight(HttpServletRequest request,HttpServletResponse response, Model model) {
		String departure=request.getParameter("departure");  
		String arrival=request.getParameter("arrival");  
		String departureCity=request.getParameter("departureCity");  
		String destination=request.getParameter("destination");  
		String airlineName=request.getParameter("airlineName");  
	    String fare=request.getParameter("fare");
	    String price=request.getParameter("price");
	    String adults=request.getParameter("adults");
	    String kids=request.getParameter("kids");
	    
	    flight=new Flight(departure,arrival,departureCity,destination,
	    		airlineName,fare,Double.parseDouble(price));
	    fr.save(flight);
	    
	    totalPassenger=Integer.parseInt(adults)+Integer.parseInt(kids);
	    totalCost=totalPassenger*Double.parseDouble(price);
	    
	    if(fare.equals("Round trip"))
	    {
	    	totalCost=totalCost*2;
	    }
		model.addAttribute("title", "Payment");		 
	    return "payment";
	}
	
	@PostMapping("/pay")  
	  //method to process payment request
	public String processPayment(HttpServletRequest request,HttpServletResponse response, Model model) {
	    fr.saveAndFlush(flight);	    
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String currentTime=dtf.format(now).toString(); 
		reservation = new Reservation(passenger.getCustId(),
		flight.getFlightCode(),totalPassenger,
		totalCost,currentTime);
		rr.saveAndFlush(reservation);
		
		model.addAttribute("message", "Flight booked successfully");
    	model.addAttribute("user", passenger);
		model.addAttribute("flight", flight);
		model.addAttribute("reservation", reservation);
		model.addAttribute("title", "Summary");
		return "success";
	}
	@GetMapping("/bookings")  
	  //method to show bookings request
	public String viewFlight(Model model) {
		
		model.addAttribute("title", "Manage");
		//System.out.println(passenger.toString());
		//passenger.getCustId();
		
		//List<Reservation> rs= passenger.getReservationList();
		List<Reservation> rs= rr.findByCustId(passenger.getCustId());
		List<Flight>fl=new ArrayList<Flight>();
		for(Reservation r : rs)
		{
			fl.add(fr.findByReservationId(r.getFlightCode()));
		}
		model.addAttribute("flights", fl);
    	model.addAttribute("user", passenger);

	    return "viewbookings";
	}	
	
	@GetMapping("/edit")  
	  //method to process edit request
	public String editFlight(HttpServletRequest request,HttpServletResponse response, Model model) {
		
		String flightCodeString=request.getParameter("id");
		Flight fl=fr.getById(Integer.parseInt(flightCodeString));
		model.addAttribute("flight",fl);
    	model.addAttribute("user", passenger);
		 
	    return "edit";
	}
	
	@PostMapping("/update")  
	  //method to process update request
	public String updateFlight(HttpServletRequest request,HttpServletResponse response, Model model) {
		
		String flightCodeString=request.getParameter("id");
		String departure=request.getParameter("departure");
		String arrival=request.getParameter("arrival");
		fr.updateFlight(departure, arrival, Integer.parseInt(flightCodeString));
    	model.addAttribute("user", passenger);

	    return "home";
	}
	@GetMapping("/cancel")  
	  //method to process cancel request
	public String cancelFlight(HttpServletRequest request,HttpServletResponse response, Model model) {
		
		String flightCodeString=request.getParameter("id");
		Flight fl=fr.getById(Integer.parseInt(flightCodeString));
		Reservation rs = fl.getReservation();
		passenger.getReservationList().remove(rs);
		fl.setReservation(null);
		fr.delete(fl);
		model.addAttribute("user", passenger);

	    return "home";
	}
	@RequestMapping("/profile")
	//method to process flight booking
	public String profile(Model model)
	{
		model.addAttribute("title", "Profile");
		Passenger currentP=auth.getById(passenger.getCustId());
	    model.addAttribute("user", currentP);
		return "editprofile";
	}
	@PostMapping("/update-user")  
	  //method to process update request
	public String update(HttpServletRequest request,HttpServletResponse response, Model model) {
		String id=request.getParameter("id");
		String phone=request.getParameter("phoneNumber");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String postal=request.getParameter("postalCode");
		//Passenger pp = auth.getById(Integer.parseInt(id));
		
		auth.updatePassenger(phone, address, city, postal, Integer.parseInt(id));
		model.addAttribute("title", "Home");
	    model.addAttribute("user", passenger);
	    return "home";
	}
}
