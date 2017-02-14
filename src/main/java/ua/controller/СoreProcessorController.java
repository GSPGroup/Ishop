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

import ua.entity.ÑoreProcessor;
import ua.form.ÑoreProcessorForm;
import ua.form.filter.ÑoreProcessorFilterForm;
import ua.service.ÑoreProcessorService;
import ua.service.implementation.editor.ÑoreProcessorEditor;
import ua.service.implementation.validator.ÑoreProcessorValidator;

@Controller
public class ÑoreProcessorController {
	
	@Autowired
	private ÑoreProcessorService coreprocessorService;  // ³ñíóº äëÿ ³ìïîðòó âñ³õ ñåðâ³ñ³â.
	
	@ModelAttribute("coreprocessor")   // ìîäåëü àòðèáóò âèêîðèñòîâóºòüñÿ íà jsp äëÿ òîãî øîá ïðåäàâàòè ³ìåííî ôîðìó
	public ÑoreProcessorForm getForm(){ // ³ìïîðòóºìî ñòð³íãîâó ôîðìó äëÿ ³íòîâèõ çíà÷åíü
		return new ÑoreProcessorForm(); // ïåðåäàºì ïóñòó ôîðìó ç ñòð³íãîâèìè ïîëÿìè
	}
	
	@ModelAttribute("filter") // âèêîðèñòîâóºòüñÿ äëÿ jsp äëÿ ïåðåäà÷³ ïàðàìåòð³â ô³ëüòðà
	public ÑoreProcessorFilterForm getFilter(){ // ³ìîïðòóºì ôîðìó äëÿ ô³ëüòðóâàííÿ
		return new ÑoreProcessorFilterForm();// ïåðåäàºì ïóñòèé ô³ëüòð
	}
	
	@InitBinder("coreprocessor") 
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(ÑoreProcessor.class, new ÑoreProcessorEditor(coreprocessorService));
	   binder.setValidator(new ÑoreProcessorValidator(coreprocessorService));
	}

	@RequestMapping("/admin/coreprocessor") // ñèëêà â áðàóçåð³ 
	public String show(Model model,
			@PageableDefault(5) Pageable pageable, //@PageableDefault ïåðåäàº âåôîëòíå çíà÷åííÿ ñê³ëüêè åëåìåíò³â áóäå íà ñòîð³íö³
			@ModelAttribute(value="filter") ÑoreProcessorFilterForm form){
		model.addAttribute("page", coreprocessorService.findAll(pageable, form));
		return "adminÑoreProcessor";
	}
	
	@RequestMapping("/admin/coreprocessor/delete/{id}")// ñèëêà â áðàóçåð³  
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ÑoreProcessorFilterForm form){
		coreprocessorService.delete(id);
		return "redirect:/admin/coreprocessor"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/coreprocessor/update/{id}")
	public String update(Model model,
			@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ÑoreProcessorFilterForm form){
		model.addAttribute("coreprocessor", coreprocessorService.findOne(id));
		model.addAttribute("page", coreprocessorService.findAll(pageable, form));
		return "adminÑoreProcessor";
	}
	
	@RequestMapping(value= "/admin/coreprocessor", method=RequestMethod.POST)
	public String save(@ModelAttribute("coreprocessor") @Valid ÑoreProcessorForm coreprocessor,
			BindingResult br,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ÑoreProcessorFilterForm form,
			Model model){
		if(br.hasErrors()){
			model.addAttribute("page", coreprocessorService.findAll(pageable, form));
			return "adminÑoreProcessor";
		}
		coreprocessorService.save(coreprocessor);
		return "redirect:/admin/coreprocessor"+getParams(pageable, form);
	}
	
	
	
	private String getParams(Pageable pageable, ÑoreProcessorFilterForm form){
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
