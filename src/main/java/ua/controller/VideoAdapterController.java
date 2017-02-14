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

import ua.form.VideoAdapterForm;
import ua.form.filter.VideoAdapterFilterForm;
import ua.service.VideoAdapterService;
import ua.service.implementation.validator.VideoAdapterValidator;

@Controller
public class VideoAdapterController {

	@Autowired
	private VideoAdapterService videoadapterService;

	@ModelAttribute("videoadapter")
	public VideoAdapterForm getForm() {
		return new VideoAdapterForm();
	}

	@ModelAttribute("filter")
	public VideoAdapterFilterForm getFilter() {
		return new VideoAdapterFilterForm();
	}

	@InitBinder("videoadapter")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new VideoAdapterValidator(videoadapterService));
	}

	@RequestMapping("/admin/videoadapter")
	public String show(Model model, @PageableDefault(5) Pageable pageable,
			@ModelAttribute(value = "filter") VideoAdapterFilterForm form) {
		model.addAttribute("page", videoadapterService.findAll(pageable, form));
		return "adminVideoAdapter";
	}

	@RequestMapping("/admin/videoadapter/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value = "filter") VideoAdapterFilterForm form) {
		videoadapterService.delete(id);
		return "redirect:/admin/videoadapter" + getParams(pageable, form);
	}

	@RequestMapping("/admin/videoadapter/update/{id}")
	public String update(Model model, @PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value = "filter") VideoAdapterFilterForm form) {
		model.addAttribute("videoadapter", videoadapterService.findOne(id));
		model.addAttribute("page", videoadapterService.findAll(pageable, form));
		return "adminVideoAdapter";
	}

	@RequestMapping(value = "/admin/videoadapter", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("videoadapter") @Valid VideoAdapterForm videoadapter,
			BindingResult br, @PageableDefault(5) Pageable pageable,
			@ModelAttribute(value = "filter") VideoAdapterFilterForm form,
			Model model) {
		if (br.hasErrors()) {
			model.addAttribute("page",
					videoadapterService.findAll(pageable, form));
			return "adminVideoAdapter";
		}
		videoadapterService.save(videoadapter);
		return "redirect:/admin/videoadapter" + getParams(pageable, form);
	}

	private String getParams(Pageable pageable, VideoAdapterFilterForm form) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber() + 1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if (pageable.getSort() != null) {
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order) -> {
				buffer.append(order.getProperty());
				if (order.getDirection() != Direction.ASC)
					buffer.append(",desc");
			});
		}
		buffer.append("&search=");
		buffer.append(form.getSearch());
		return buffer.toString();
	}
}
