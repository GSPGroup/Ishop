package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Hdd;
import ua.form.filter.HddFilterForm;

public class HddFilterAdapter implements Specification<Hdd>{

	private String search = "";

	public HddFilterAdapter(HddFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<Hdd> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class && query.getResultType() != long.class) {
//			root.fetch("ingredient");
//			root.fetch("measuringSystem");
//			query.distinct(true);
		}
		if(search.isEmpty())return null;
		Expression<String> exp = root.get("hddGb");
		return cb.equal(exp, search);
	}
	
	
}
