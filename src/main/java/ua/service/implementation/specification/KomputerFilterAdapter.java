package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Komputer;
import ua.form.filter.KomputerFilterForm;

public class KomputerFilterAdapter implements Specification<Komputer>{

	private String search = "";

	public KomputerFilterAdapter(KomputerFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<Komputer> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class && query.getResultType() != long.class) {
			root.fetch("hdd");
			root.fetch("ram");
			root.fetch("processor");
			root.fetch("videoadapter");
//			query.distinct(true);
		}
		if(search.isEmpty())return null;
		Expression<String> exp = root.get("price");
		return cb.equal(exp, search);
	}
	
	
}
