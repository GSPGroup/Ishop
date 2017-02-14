package ua.controllerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.form.filter.ProcessorFilterForm;
import ua.service.ProcessorService;
import ua.service.TypeProcessorService;
import ua.service.ÑoreProcessorService;

@Controller
public class ProcessorUserController {
	
	@Autowired
	private ProcessorService processorService;
	
	@Autowired
	private TypeProcessorService typeprocessorService;
	
	@Autowired
	private ÑoreProcessorService coreprocessorService;
	
	@ModelAttribute("filter")
	public ProcessorFilterForm getFilter(){
		return new ProcessorFilterForm();
	}

	@RequestMapping("/processor")
	public String show(Model model,
			@PageableDefault() Pageable pageable,
			@ModelAttribute(value="filter") ProcessorFilterForm form){
		model.addAttribute("page", processorService.findAll(pageable, form));
		model.addAttribute("typeprocessors", typeprocessorService.findAll());
		model.addAttribute("coreprocessors", coreprocessorService.findAll());
		return "processor";
	}
	
//	private String getParams(Pageable pageable, ProcessorFilterForm form){
//		StringBuilder buffer = new StringBuilder();
//		buffer.append("?page=");
//		buffer.append(String.valueOf(pageable.getPageNumber()+1));
//		buffer.append("&size=");
//		buffer.append(String.valueOf(pageable.getPageSize()));
//		if(pageable.getSort()!=null){
//			buffer.append("&sort=");
//			Sort sort = pageable.getSort();
//			sort.forEach((order)->{
//				buffer.append(order.getProperty());
//				if(order.getDirection()!=Direction.ASC)
//				buffer.append(",desc");
//			});
//		}
//		buffer.append("&search=");
//		buffer.append(form.getSearch());
//		return buffer.toString();
//	}
}
