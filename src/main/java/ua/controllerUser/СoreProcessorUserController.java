package ua.controllerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.form.�oreProcessorForm;
import ua.form.filter.�oreProcessorFilterForm;
import ua.service.�oreProcessorService;

@Controller
public class �oreProcessorUserController {
	
	@Autowired
	private �oreProcessorService coreprocessorService;
	
	@ModelAttribute("coreprocessor")
	public �oreProcessorForm getForm(�oreProcessorForm form){
		return new �oreProcessorForm();
	}
	
	@ModelAttribute("filter")
	public �oreProcessorFilterForm getFilter(){
		return new �oreProcessorFilterForm();
	}
	
	@RequestMapping("/coreprocessor")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") �oreProcessorFilterForm form){
		model.addAttribute("page", coreprocessorService.findAll(pageable, form));
		return "coreprocessor";
	}
	
}
