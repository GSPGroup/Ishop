package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Processor;
import ua.form.filter.ProcessorFilterForm;

public class ProcessorFilterAdapter implements Specification<Processor>{

	private String search = "";

	public ProcessorFilterAdapter(ProcessorFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<Processor> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class && query.getResultType() != long.class) {
			root.fetch("typeprocessor");
			root.fetch("coreprocessor");
//			query.distinct(true);
		}
		Expression<String> exp = root.get("name");
		return cb.like(cb.upper(exp), search.toUpperCase()+"%");
	}
	
	
}
