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

import ua.entity.Hdd;
import ua.entity.Processor;
import ua.entity.Ram;
import ua.entity.VideoAdapter;
import ua.form.KomputerForm;
import ua.form.filter.KomputerFilterForm;
import ua.service.HddService;
import ua.service.KomputerService;
import ua.service.ProcessorService;
import ua.service.RamServiñe;
import ua.service.VideoAdapterService;
import ua.service.implementation.editor.HddEditor;
import ua.service.implementation.editor.ProcessorEditor;
import ua.service.implementation.editor.RamEditor;
import ua.service.implementation.editor.VideoAdapterEditor;
import ua.service.implementation.validator.KomputerValidator;

@Controller
public class KomputerController {

	@Autowired
	private KomputerService komputerService;

	@Autowired
	private HddService hddService;
	
	@Autowired
	private ProcessorService processorService;

	@Autowired
	private RamServiñe ramServiñe;
	
	@Autowired
	private VideoAdapterService videoadapterService;
	

	@ModelAttribute("komputer")
	public KomputerForm getForm(){
		return new KomputerForm();
	}
	
	@ModelAttribute("filter")
	public KomputerFilterForm getFilter(){
		return new KomputerFilterForm();
	}
	
	@InitBinder("komputer")
	protected void initBinder(WebDataBinder binder){
		 binder.registerCustomEditor(Hdd.class, new HddEditor(hddService));
		 binder.registerCustomEditor(Ram.class, new RamEditor(ramServiñe));
		 binder.registerCustomEditor(VideoAdapter.class, new VideoAdapterEditor(videoadapterService));
		 binder.registerCustomEditor(Processor.class, new ProcessorEditor(processorService));
	   binder.setValidator(new KomputerValidator(komputerService));
	}

	@RequestMapping("/admin/komputer")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") KomputerFilterForm form){
		model.addAttribute("page", komputerService.findAll(pageable, form));
		model.addAttribute("hdds", hddService.findAll());
		model.addAttribute("rams", ramServiñe.findAll());
		model.addAttribute("processors", processorService.findAll());
		model.addAttribute("videoadapters", videoadapterService.findAll());
		return "adminKomputer";
	}
	
	@RequestMapping("/admin/komputer/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") KomputerFilterForm form){
		komputerService.delete(id);
		return "redirect:/admin/komputer"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/komputer/update/{id}")
	public String update(Model model,
			@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") KomputerFilterForm form){
		model.addAttribute("page", komputerService.findAll(pageable, form));
		model.addAttribute("komputer", komputerService.findOne(id));
		model.addAttribute("hdds", hddService.findAll());
		model.addAttribute("rams", ramServiñe.findAll());
		model.addAttribute("processors", processorService.findAll());
		model.addAttribute("videoadapters", videoadapterService.findAll());
		return "adminKomputer";
	}
	
	@RequestMapping(value= "/admin/komputer", method=RequestMethod.POST)
	public String save(@ModelAttribute("komputer") @Valid KomputerForm komputer,
			BindingResult br,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") KomputerFilterForm form,
			Model model){
		if(br.hasErrors()){
			model.addAttribute("page", komputerService.findAll(pageable, form));
			model.addAttribute("hdds", hddService.findAll());
			model.addAttribute("rams", ramServiñe.findAll());
			model.addAttribute("processors", processorService.findAll());
			model.addAttribute("videoadapters", videoadapterService.findAll());
			return "adminKomputer";
		}
		komputerService.save(komputer);
		return "redirect:/admin/komputer"+getParams(pageable, form);
	}
	
	
	
	private String getParams(Pageable pageable, KomputerFilterForm form){
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
