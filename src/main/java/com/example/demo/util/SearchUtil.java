package com.example.demo.util;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.constant.common.Constants;
import com.example.demo.constant.common.SortOrderEnum;

@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
public class SearchUtil {
	public static Pageable getPageableFromParam(Integer page, Integer size, String sort, SortOrderEnum order) {
		Sort sortRequest;
		if (sort != null) {
			sortRequest = Sort.by(order == SortOrderEnum.ASC ? Direction.ASC : Direction.DESC, sort);
		} else {
			sortRequest = Sort.unsorted();
		}
		if (size == null || size > Constants.DEFAULT_PAGE_SIZE_MAX) {
			size = Constants.DEFAULT_PAGE_SIZE_MAX;
		}
		return PageRequest.of(page, size, sortRequest);
	}

	public static <T> Specification<T> like(String fieldName, String value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (value != null) {
					return cb.like(cb.lower(root.get(fieldName)), value.toLowerCase());
				}
				return cb.conjunction();
			}
		};
	}

	public static <R, F> Specification<R> in(String fieldName, List<F> filterList) {
		return new Specification<R>() {
			@Override
			public Predicate toPredicate(Root<R> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (filterList != null && !filterList.isEmpty()) {
					if (filterList.size() > 1) {
						In<F> inClause = cb.in(root.get(fieldName));
						filterList.forEach(e -> inClause.value(e));
						return inClause;
					} else {
						return cb.equal(root.<Comparable>get(fieldName), filterList.get(0));
					}
				}
				return cb.conjunction();
			}
		};
	}

	public static <T> Specification<T> eq(String fieldName, Object value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (value != null) {
					return cb.equal(root.<Comparable>get(fieldName), value);
				}
				return cb.conjunction();
			}
		};
	}

	public static <T> Specification<T> gt(String fieldName, Comparable value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (value != null) {
					cb.greaterThan(root.<Comparable>get(fieldName), value);
				}
				return cb.conjunction();
			}
		};
	}

	public static <T> Specification<T> ge(String fieldName, Comparable value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (value != null) {
					return cb.greaterThanOrEqualTo(root.<Comparable>get(fieldName), value);
				}
				return cb.conjunction();
			}
		};
	}

	public static <T> Specification<T> lt(String fieldName, Comparable value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (value != null) {
					return cb.lessThan(root.<Comparable>get(fieldName), value);
				}
				return cb.conjunction();
			}
		};
	}

	public static <T> Specification<T> le(String fieldName, Comparable value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (value != null) {
					cb.lessThanOrEqualTo(root.<Comparable>get(fieldName), value);
				}
				return cb.conjunction();
			}
		};
	}

}
