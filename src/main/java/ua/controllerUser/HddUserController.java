package ua.controllerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.TypeHdd;
import ua.form.filter.HddFilterForm;
import ua.service.HddService;
import ua.service.implementation.validator.HddValidator;

@Controller
public class HddUserController {
	
	@Autowired
	private HddService hddGbService;
	
	
	@ModelAttribute("filter")
	public HddFilterForm getFilter(){
		return new HddFilterForm();
	}
	
	@InitBinder("hddGb")
	protected void initBinder(WebDataBinder binder){
	   binder.setValidator(new HddValidator(hddGbService));
	}

	@RequestMapping("/hdd")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") HddFilterForm form){
		model.addAttribute("page", hddGbService.findAll(pageable, form));
		model.addAttribute("hdds", TypeHdd.values());
		return "hdd";
	}
	
//	private String getParams(Pageable pageable, HddFilterForm form){
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
