package ua.controllerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.form.RamForm;
import ua.form.filter.RamFilterForm;
import ua.service.RamServiñe;

@Controller
public class RamUserController {
	
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
	

	@RequestMapping("/ram")
	public String show(Model model,
			@PageableDefault(6) Pageable pageable,
			@ModelAttribute(value="filter") RamFilterForm form){
		model.addAttribute("page", ramService.findAll(pageable, form));
		return "ram";
	}
	
//	private String getParams(Pageable pageable, RamFilterForm form){
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
