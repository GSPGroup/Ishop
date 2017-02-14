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

import ua.entity.TypeHdd;
import ua.form.HddForm;
import ua.form.filter.HddFilterForm;
import ua.service.HddService;
import ua.service.implementation.validator.HddValidator;

@Controller
public class HddController {
	
	@Autowired
	private HddService hddGbService;
	
	@ModelAttribute("hdd")
	public HddForm getForm(HddForm form){
		return new HddForm();
	}
	
	@ModelAttribute("filter")
	public HddFilterForm getFilter(){
		return new HddFilterForm();
	}
	
	@InitBinder("hddGb")
	protected void initBinder(WebDataBinder binder){
	   binder.setValidator(new HddValidator(hddGbService));
	}

	@RequestMapping("/admin/hdd")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") HddFilterForm form){
		model.addAttribute("page", hddGbService.findAll(pageable, form));
		model.addAttribute("hdds", TypeHdd.values());
		return "adminHdd";
	}
	
	@RequestMapping("/admin/hdd/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") HddFilterForm form){
		hddGbService.delete(id);
		return "redirect:/admin/hdd"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/hdd/update/{id}")
	public String update(Model model,
			@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") HddFilterForm form){
		model.addAttribute("hdd", hddGbService.findOne(id));
		model.addAttribute("page", hddGbService.findAll(pageable, form));
		model.addAttribute("hdds", TypeHdd.values());
		return "adminHdd";
	}
	
	@RequestMapping(value= "/admin/hdd", method=RequestMethod.POST)
	public String save(@ModelAttribute("hddGb") @Valid HddForm hddGb,
			BindingResult br,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") HddFilterForm form,
			Model model){
		if(br.hasErrors()){
			model.addAttribute("hdds", TypeHdd.values());
			model.addAttribute("page", hddGbService.findAll(pageable, form));
			return "adminHdd";
		}
		hddGbService.save(hddGb);
		return "redirect:/admin/hdd"+getParams(pageable, form);
	}
	
	
	
	private String getParams(Pageable pageable, HddFilterForm form){
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
