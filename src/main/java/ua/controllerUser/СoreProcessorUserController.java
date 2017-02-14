package ua.controllerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.form.ÑoreProcessorForm;
import ua.form.filter.ÑoreProcessorFilterForm;
import ua.service.ÑoreProcessorService;

@Controller
public class ÑoreProcessorUserController {
	
	@Autowired
	private ÑoreProcessorService coreprocessorService;
	
	@ModelAttribute("coreprocessor")
	public ÑoreProcessorForm getForm(ÑoreProcessorForm form){
		return new ÑoreProcessorForm();
	}
	
	@ModelAttribute("filter")
	public ÑoreProcessorFilterForm getFilter(){
		return new ÑoreProcessorFilterForm();
	}
	
	@RequestMapping("/coreprocessor")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ÑoreProcessorFilterForm form){
		model.addAttribute("page", coreprocessorService.findAll(pageable, form));
		return "coreprocessor";
	}
	
}
