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

import ua.form.RamForm;
import ua.form.filter.RamFilterForm;
import ua.service.RamServiñe;
import ua.service.implementation.validator.RamValidator;

@Controller
public class RamController {
	
	@Autowired
	private RamServiñe ramService;
	
	@ModelAttribute("ram")
	public RamForm getForm(RamForm form){
		return new RamForm();
	}
	
	@ModelAttribute("filter")
	public RamFilterForm getFilter(){
		return new RamFilterForm();
	}
	
	@InitBinder("ramGb")
	protected void initBinder(WebDataBinder binder){
		
	   binder.setValidator(new RamValidator(ramService));
	}

	@RequestMapping("/admin/ram")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") RamFilterForm form){
		model.addAttribute("page", ramService.findAll(pageable, form));
		return "adminRam";
	}
	

	
	@RequestMapping("/admin/ram/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") RamFilterForm form){
		ramService.delete(id);
		return "redirect:/admin/ram"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/ram/update/{id}")
	public String update(Model model,
			@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") RamFilterForm form){
		model.addAttribute("ram", ramService.findOne(id));
		model.addAttribute("page", ramService.findAll(pageable, form));
		return "adminRam";
	}
	
	@RequestMapping(value= "/admin/ram", method=RequestMethod.POST)
	public String save(@ModelAttribute("ramGb") @Valid RamForm ramGb,
			BindingResult br,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") RamFilterForm form,
			Model model){
		if(br.hasErrors()){
			model.addAttribute("page", ramService.findAll(pageable, form));
			return "adminRam";
		}
		ramService.save(ramGb);
		return "redirect:/admin/ram"+getParams(pageable, form);
	}
	
	
	
	private String getParams(Pageable pageable, RamFilterForm form){
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
