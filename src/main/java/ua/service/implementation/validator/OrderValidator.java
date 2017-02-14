//package ua.service.implementation.validator;
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import ua.form.OrderForm;
//import ua.service.OrderService;
//
//public class OrderValidator implements Validator {
//
//	private final OrderService orderService;
////	private static final Pattern p = Pattern.compile("^[a-z]{1,15}$");
//
//	public OrderValidator(OrderService orderService) {
//		this.orderService = orderService;
//	}
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return OrderForm.class.equals(clazz);
//	}
//	
//	@Override
//	public void validate(Object target, Errors errors) {
//		OrderForm form = (OrderForm) target;
////		if(form.getId()==0)if(orderService.findByName(form.getName())!=null){
////			errors.rejectValue("name", "", "Order already exists");
////		}
////		Matcher m = p.matcher(form.getName());
////		if(!m.matches()){
////			errors.rejectValue("name", "", "name format is a-z ");
////		}
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "", "Can`t be empty");
//	}
//}
