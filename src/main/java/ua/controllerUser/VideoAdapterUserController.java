package ua.controllerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.VideoAdapter;
import ua.form.filter.VideoAdapterFilterForm;
import ua.service.VideoAdapterService;

@Controller
public class VideoAdapterUserController {

	@Autowired
	private VideoAdapterService videoadapterService;

	@ModelAttribute("videoadapter")
	public VideoAdapter getForm() {
		return new VideoAdapter();
	}

	@ModelAttribute("filter")
	public VideoAdapterFilterForm getFilter() {
		return new VideoAdapterFilterForm();
	}

	@RequestMapping("/videoadapter")
	public String show(Model model, @PageableDefault(5) Pageable pageable,
			@ModelAttribute(value = "filter") VideoAdapterFilterForm form) {
		model.addAttribute("page", videoadapterService.findAll(pageable, form));
		return "videoadapter";
	}

//	private String getParams(Pageable pageable, VideoAdapterFilterForm form) {
//		StringBuilder buffer = new StringBuilder();
//		buffer.append("?page=");
//		buffer.append(String.valueOf(pageable.getPageNumber() + 1));
//		buffer.append("&size=");
//		buffer.append(String.valueOf(pageable.getPageSize()));
//		if (pageable.getSort() != null) {
//			buffer.append("&sort=");
//			Sort sort = pageable.getSort();
//			sort.forEach((order) -> {
//				buffer.append(order.getProperty());
//				if (order.getDirection() != Direction.ASC)
//					buffer.append(",desc");
//			});
//		}
//		buffer.append("&search=");
//		buffer.append(form.getSearch());
//		return buffer.toString();
//	}
}
