package com.springboot.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.validation.Valid;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {
	//Passenger
	private final String baseUrl = "http://host.docker.internal:8084/"; //microservice url
	private RestTemplate rest = new RestTemplate();
	private Passenger savePassenger; //logged in passenger
	
	//get login page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model)
	{
		Passenger passenger = new Passenger();
		model.addAttribute("passenger", passenger);
		return "loginPassenger";
	}
	
	//get register page 
	@RequestMapping(value = "/passenger/register", method = RequestMethod.GET)
	public String register(Model model)
	{
		Passenger passenger = new Passenger();
		model.addAttribute("passenger", passenger);
		return "addPassenger";
	}
	
	//process register passenger request
	@RequestMapping(value = "/passenger/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addPassenger(@Valid Passenger passenger, BindingResult result, Model model) throws Exception
    {
		if (result.hasErrors()) {
	        	
	            return "addPassenger";
	        }
		
        ResponseEntity<Passenger> responseEntity = rest.postForEntity(baseUrl+"passenger/add", passenger, Passenger.class);
        if(responseEntity.getBody()==null)
        {
        	model.addAttribute("message", "Email already exists");
        }
		return "loginPassenger";
    }
	
	//process login request
	@RequestMapping(value = "/passenger/login", method = RequestMethod.GET)
    public String loginPassenger(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception
    {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String url = baseUrl+"passenger/{email}&{password}";
		
		Map<String, String> param = new HashMap<>();
		param.put("email", email);
		param.put("password", password);
		Passenger passenger=rest.getForObject(url, Passenger.class, param);
		if(passenger!=null)
		{
			savePassenger = passenger;
			model.addAttribute("passenger", passenger);
			return "redirect:/card/view";
		}
		System.out.println(passenger);
		return "loginPassenger";
    }
	
	//Card
	
	//view card details
	@RequestMapping(value = "/card/view", method = RequestMethod.GET)
	public String dashboard(Model model)
	{ 
		//Passenger passenger = (Passenger) model.getAttribute("passenger");
		//System.out.println(savePassenger);
		String url = baseUrl+"card/{custId}";
		Map<String, String> param = new HashMap<>();
		param.put("custId", savePassenger.getPassengerId());
		Card card = rest.getForObject(url, Card.class, param);
		if(card==null)
		{
			card=new Card();
		}
		
		model.addAttribute("card", card);
		
		return "cardDetails";
	}
	
	//get add card page
	@RequestMapping(value = "/card/add", method = RequestMethod.GET)
	public String addCard(Model model)
	{
		Card card = new Card();
		model.addAttribute("card", card);
		return "addCard";
	}
	
	//process add card request
	@RequestMapping(value = "/card/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String saveCard(@Valid Card card, BindingResult result)
	{		
		if (result.hasErrors()) {
        return "addCard";
    }
		card.setCustId(savePassenger.getPassengerId());
		card.setBalance(card.getPrice());
		card.setStatus("Active");
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String strDate = dateFormat.format(date);  
		card.setTransDate(strDate);
		rest.postForEntity(baseUrl+"card/add", card, Card.class);
		return "redirect:/card/view";	
	}
	
	//get authentication page
	@RequestMapping(value = "/card/auth/{cardNo}", method = RequestMethod.GET)
	public String authCardForm(@PathVariable("cardNo") final String cardNo,Model model)
	{
		model.addAttribute("cardNo", cardNo);
		return "authCard";
	}
	
	//process authentication
	@RequestMapping(value = "/card/auth", method = RequestMethod.POST)
	public String authCard(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		String cardNo = request.getParameter("cardNo");
		String pin = request.getParameter("pin");
				
		String url = baseUrl+"card/auth/{cardNo}&{pin}";
		
		Map<String, String> param = new HashMap<>();
		param.put("cardNo", cardNo);
		param.put("pin", pin);
		Card card=rest.getForObject(url, Card.class, param);
		if(card==null)
		{
			return "redirect:/card/view";
		}
		
		else
		{
			model.addAttribute("card", card);
			return "cardDetails";
		}
	}
	
	//process card transaction
	@RequestMapping(value = "/card/transaction/{cardNo}", method = RequestMethod.GET)
	public String transaction(@PathVariable("cardNo") final String cardNo,Model model)
	{
		String url = baseUrl+"card/transaction/{cardNo}";
		
		Map<String, String> param = new HashMap<>();
		param.put("cardNo", cardNo);
		rest.put(url, Card.class, param);
		return "redirect:/card/view";
	}
	
	//get topup page
	@RequestMapping(value = "/card/topup/{cardNo}", method = RequestMethod.GET)
	public String topupForm(@PathVariable("cardNo") final String cardNo,Model model)
	{
		model.addAttribute("cardNo", cardNo);
		return "topupCard";
	}
	
	//process topup
	@RequestMapping(value = "/card/topup", method = RequestMethod.POST)
	public String topup(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		String cardNo = request.getParameter("cardNo");
		String price = request.getParameter("price");
				
		String url = baseUrl+"card/topup/{cardNo}&{price}";
		
		Map<String, String> param = new HashMap<>();
		param.put("cardNo", cardNo);
		param.put("price", price);
		rest.put(url, Card.class, param);
		return "redirect:/card/view";
	}
}
