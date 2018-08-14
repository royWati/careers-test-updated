package com.chainbox.safaricom.careerstest.domain.jobsearch;

import com.chainbox.safaricom.careerstest.domain.Job;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SearchSpecifications implements Specification<Job> {
    private SearchCriteria criteria;

    public SearchSpecifications(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Specification<Job> and(Specification<Job> other) {
        return null;
    }

    @Override
    public Specification<Job> or(Specification<Job> other) {
        return null;
    }

    @Nullable
    @Override
    public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }

    public void with(String group, String group1, String group2) {
    }
}
