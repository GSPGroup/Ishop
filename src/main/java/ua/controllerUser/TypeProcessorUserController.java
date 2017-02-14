package ua.controllerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.TypeProcessor;
import ua.form.filter.TypeProcessorFilterForm;
import ua.service.TypeProcessorService;

@Controller
public class TypeProcessorUserController {
	
	@Autowired
	private TypeProcessorService typeprocessorService;
	
	@ModelAttribute("typeprocessor")
	public TypeProcessor getForm(){
		return new TypeProcessor();
	}
	
	@ModelAttribute("filter")
	public TypeProcessorFilterForm getFilter(){
		return new TypeProcessorFilterForm();
	}
	
	@RequestMapping("/typeprocessor")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") TypeProcessorFilterForm form){
		model.addAttribute("page", typeprocessorService.findAll(pageable, form));
		return "typeprocessor";
	}
	
//	private String getParams(Pageable pageable, TypeProcessorFilterForm form){
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
