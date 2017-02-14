package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.�oreProcessor;
import ua.form.filter.�oreProcessorFilterForm;

public class �oreProcessorFilterAdapter implements Specification<�oreProcessor>{

	private String search = "";

	public �oreProcessorFilterAdapter(�oreProcessorFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<�oreProcessor> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class && query.getResultType() != long.class) {
//			root.fetch("ingredient");
//			root.fetch("measuringSystem");
//			query.distinct(true);
		}
		if(search.isEmpty())return null;
		Expression<String> exp = root.get("core");
		return cb.equal(exp, search);
	}
	
	
}
