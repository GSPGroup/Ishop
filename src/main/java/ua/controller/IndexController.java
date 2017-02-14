package ua.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String showIndex(Principal principal){
//		System.out.println(principal);
//		System.out.println(System.getProperty("catalina.home"));
		System.out.println("gotovo");
		return "index";
	}
	
	@RequestMapping("/admin")
	public String showAdmin() {
		return "adminPanel";
	}
	
//	@RequestMapping("/coreprocessor")
//	public String show() {
//		return "coreprocessor";
//	}
	
	
	@RequestMapping("/contactus")
	public String showcontactus() {
		return "contactus";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	

	@RequestMapping("/adminRam")
	public String showAdminRam() {
		return "adminRam";
	}
	
	
	@RequestMapping("/adminVideoadapter")
	public String showAdminVideoAdapter() {
		return "adminvideoadapter";
	}

	@RequestMapping("/adminTypeProcessor")
	public String showAdminTypeProcessor() {
		return "admintypeprocessor";
	}

	@RequestMapping("/admin—oreProcessor")
	public String showAdmin—oreProcessor() {
		return "admincoreprocessor";
	}

	@RequestMapping("/adminHdd")
	public String showAdminHdd() {
		return "adminhdd";
	}
}
