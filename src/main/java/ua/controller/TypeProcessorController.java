package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.form.TypeProcessorForm;
import ua.form.filter.TypeProcessorFilterForm;
import ua.service.TypeProcessorService;
import ua.service.implementation.validator.TypeProcessorValidator;

@Controller
public class TypeProcessorController {
	
	@Autowired
	private TypeProcessorService typeprocessorService;
	
	@ModelAttribute("typeprocessor")
	public TypeProcessorForm getForm(){
		return new TypeProcessorForm();
	}
	
	@ModelAttribute("filter")
	public TypeProcessorFilterForm getFilter(){
		return new TypeProcessorFilterForm();
	}
	
	@InitBinder("typeprocessor")
	protected void initBinder(WebDataBinder binder){
	   binder.setValidator(new TypeProcessorValidator(typeprocessorService));
	}

	@RequestMapping("/admin/typeprocessor")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") TypeProcessorFilterForm form){
		model.addAttribute("page", typeprocessorService.findAll(pageable, form));
		return "adminTypeProcessor";
	}
	
	@RequestMapping("/admin/typeprocessor/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") TypeProcessorFilterForm form){
		typeprocessorService.delete(id);
		return "redirect:/admin/typeprocessor"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/typeprocessor/update/{id}")
	public String update(Model model,
			@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") TypeProcessorFilterForm form){
		model.addAttribute("typeprocessor", typeprocessorService.findOne(id));
		model.addAttribute("page", typeprocessorService.findAll(pageable, form));
		return "adminTypeProcessor";
	}
	
	@RequestMapping(value= "/admin/typeprocessor", method=RequestMethod.POST)
	public String save(@ModelAttribute("typeprocessor") @Valid TypeProcessorForm typeprocessor,
			BindingResult br,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") TypeProcessorFilterForm form,
			Model model){
		if(br.hasErrors()){
			model.addAttribute("page", typeprocessorService.findAll(pageable, form));
			return "adminTypeProcessor";
		}
		typeprocessorService.save(typeprocessor);
		return "redirect:/admin/typeprocessor"+getParams(pageable, form);
	}
	
	
	
	private String getParams(Pageable pageable, TypeProcessorFilterForm form){
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		buffer.append("&search=");
		buffer.append(form.getSearch());
		return buffer.toString();
	}
}
