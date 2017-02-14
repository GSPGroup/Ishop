package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.VideoAdapter;
import ua.form.filter.VideoAdapterFilterForm;

public class VideoAdapterFilterAdapter implements Specification<VideoAdapter>{

	private String search = "";

	public VideoAdapterFilterAdapter(VideoAdapterFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<VideoAdapter> root, CriteriaQuery<?> query,
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
