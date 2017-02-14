//package ua.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import ua.form.OrderForm;
//import ua.form.filter.OrderFilterForm;
//import ua.service.OrderService;
//import ua.service.implementation.validator.OrderValidator;
//
//@Controller
//public class OrdersController {
//	
//	@Autowired
//	private OrderService orderService;
//	
//	@ModelAttribute("order")
//	public OrderForm getForm(){
//		return new OrderForm();
//	}
//	
//	@ModelAttribute("filter")
//	public OrderFilterForm getFilter(){
//		return new OrderFilterForm();
//	}
//	
//	@InitBinder("order")
//	protected void initBinder(WebDataBinder binder){
//	   binder.setValidator(new OrderValidator(orderService));
//	}
//
//	@RequestMapping("/admin/order")
//	public String show(Model model,
//			@PageableDefault(5) Pageable pageable,
//			@ModelAttribute(value="filter") OrderFilterForm form){
//		model.addAttribute("page", orderService.findAll(pageable, form));
//		return "adminOrder";
//	}
//	
//	@RequestMapping("/admin/order/delete/{id}")
//	public String delete(@PathVariable int id,
//			@PageableDefault(5) Pageable pageable,
//			@ModelAttribute(value="filter") OrderFilterForm form){
//		orderService.delete(id);
//		return "redirect:/admin/order"+getParams(pageable, form);
//	}
//	
//	@RequestMapping("/admin/order/update/{id}")
//	public String update(Model model,
//			@PathVariable int id,
//			@PageableDefault(5) Pageable pageable,
//			@ModelAttribute(value="filter") OrderFilterForm form){
//		model.addAttribute("order", orderService.findOne1(id));
//		model.addAttribute("page", orderService.findAll(pageable, form));
//		return "adminOrder";
//	}
//	
//	@RequestMapping(value= "/admin/order", method=RequestMethod.POST)
//	public String save(@ModelAttribute("order") @Valid OrderForm order,
//			BindingResult br,
//			@PageableDefault(5) Pageable pageable,
//			@ModelAttribute(value="filter") OrderFilterForm form,
//			Model model){
//		if(br.hasErrors()){
//			model.addAttribute("page", orderService.findAll(pageable, form));
//			return "adminOrder";
//		}
//		orderService.save(order);
//		return "redirect:/admin/order"+getParams(pageable, form);
//	}
//	
//	
//	
//	private String getParams(Pageable pageable, OrderFilterForm form){
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
//}
