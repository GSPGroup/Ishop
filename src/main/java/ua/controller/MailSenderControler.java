package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.form.MailForm;
import ua.service.implementation.MailSender;


@Controller
public class MailSenderControler {

	@Autowired
	private MailSender mailSender;
	
	@ModelAttribute("contactus")
	public MailForm getForm(){
		return new MailForm();
	}
	
	@RequestMapping(value="/contactus", method=RequestMethod.POST)
	public String save(@ModelAttribute("contactus") MailForm form){
		mailSender.sendMail(form.getSubject(), form.getMail(), form.getMessage());
//		System.out.println( form.getName());
//		System.out.println(form.getSubject());
//		System.out.println( form.getMail());
//		System.out.println( form.getMessage());
		return "redirect:/";
	}
	

	
	
	
	
	
	
}
