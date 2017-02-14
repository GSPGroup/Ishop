package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.TypeProcessor;
import ua.form.filter.TypeProcessorFilterForm;

public class TypeProcessorFilterAdapter implements Specification<TypeProcessor>{

	private String search = "";

	public TypeProcessorFilterAdapter(TypeProcessorFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<TypeProcessor> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class && query.getResultType() != long.class) {
//			root.fetch("ingredient");
//			root.fetch("measuringSystem");
//			query.distinct(true);
		}
		Expression<String> exp = root.get("name");
		return cb.like(cb.upper(exp), search.toUpperCase()+"%");
	}
	
	
}
