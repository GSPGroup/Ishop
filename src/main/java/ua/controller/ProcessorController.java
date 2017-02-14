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

import ua.entity.TypeProcessor;
import ua.entity.ÑoreProcessor;
import ua.form.ProcessorForm;
import ua.form.filter.ProcessorFilterForm;
import ua.service.ProcessorService;
import ua.service.TypeProcessorService;
import ua.service.ÑoreProcessorService;
import ua.service.implementation.editor.TypeProcessorEditor;
import ua.service.implementation.editor.ÑoreProcessorEditor;
import ua.service.implementation.validator.ProcessorValidator;

@Controller
public class ProcessorController {
	
	@Autowired
	private ProcessorService processorService;
	
	@Autowired
	private TypeProcessorService typeprocessorService;
	
	@Autowired
	private ÑoreProcessorService coreprocessorService;
	
	
	@ModelAttribute("processor")
	public ProcessorForm getForm(){
		return new ProcessorForm();
	}
	
	@ModelAttribute("filter")
	public ProcessorFilterForm getFilter(){
		return new ProcessorFilterForm();
	}
	
	@InitBinder("processor")
	protected void initBinder(WebDataBinder binder){
		 binder.registerCustomEditor(ÑoreProcessor.class, new ÑoreProcessorEditor(coreprocessorService));
		 binder.registerCustomEditor(TypeProcessor.class, new TypeProcessorEditor(typeprocessorService));
	   binder.setValidator(new ProcessorValidator(processorService));
	   
	}

	@RequestMapping("/admin/processor")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ProcessorFilterForm form){
		model.addAttribute("page", processorService.findAll(pageable, form));
		model.addAttribute("typeprocessors", typeprocessorService.findAll());
		model.addAttribute("coreprocessors", coreprocessorService.findAll());
		return "adminProcessor";
	}
	
	@RequestMapping("/admin/processor/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ProcessorFilterForm form){
		processorService.delete(id);
		return "redirect:/admin/processor"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/processor/update/{id}")
	public String update(Model model,
			@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ProcessorFilterForm form){
		model.addAttribute("page", processorService.findAll(pageable, form));
		model.addAttribute("processor", processorService.findOne(id));
		model.addAttribute("typeprocessors", typeprocessorService.findAll());
		model.addAttribute("coreprocessors", coreprocessorService.findAll());
		return "adminProcessor";
	}
	
	@RequestMapping(value= "/admin/processor", method=RequestMethod.POST)
	public String save(@ModelAttribute("processor") @Valid ProcessorForm processor,
			BindingResult br,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ProcessorFilterForm form,
			Model model){
		if(br.hasErrors()){
			model.addAttribute("page", processorService.findAll(pageable, form));
			model.addAttribute("typeprocessors", typeprocessorService.findAll());
			model.addAttribute("coreprocessors", coreprocessorService.findAll());
			return "adminProcessor";
		}
//		processor.setTypeprocessor(processor.getTypeprocessor().getId());
		processorService.save(processor);
		return "redirect:/admin/processor"+getParams(pageable, form);
	}
	
	
	
	private String getParams(Pageable pageable, ProcessorFilterForm form){
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
