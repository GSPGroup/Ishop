//package ua.service.implementation;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import ua.entity.Orders;
//import ua.form.OrderForm;
//import ua.form.filter.OrderFilterForm;
//import ua.repository.OrderRepository;
//import ua.service.OrderService;
//import ua.service.implementation.specification.OrderFilterAdapter;
//
//@Service
//@Transactional
//public class OrderImpl implements OrderService {
//	
//
//	@Autowired
//	private OrderRepository orderRepository;
//
//	@Override
//	public void save(OrderForm form) {
//		orderRepository.save(String.valueOf(form) );
//	}
//
//
//	@Override
//	public List<Orders> findAll() {
//		return orderRepository.findAll();
//	}
//
//	@Override
//	public void delete(int id) {
//		orderRepository.delete(id);
//	}
//
//
//	@Override
//	public Page<Orders> findAll(Pageable pageable) {
//		return orderRepository.findAll(pageable);
//	}
//
//
//	@Override
//	public Page<Orders> findAll(Pageable pageable, OrderFilterForm form) {
//		return orderRepository.findAll(new OrderFilterAdapter(form), pageable);
//	}
//
//
//	@Override
//	public Orders findOne1(int id) {
//		return orderRepository.findOne(id);
//	}
//
//}