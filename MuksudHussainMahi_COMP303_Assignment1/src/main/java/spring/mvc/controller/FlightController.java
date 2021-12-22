package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.model.Flight;
@Controller
public class FlightController {

    @RequestMapping(value="/reserve", method=RequestMethod.POST)
    public String viewRegistration(@ModelAttribute("flightObj") Flight flight, Model model) {
    	model.addAttribute("fare",flight.calculateFare());
    	//System.out.println(flight);
    	return "show-flight";
    }
}
