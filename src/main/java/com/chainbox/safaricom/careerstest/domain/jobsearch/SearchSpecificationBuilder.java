package com.chainbox.safaricom.careerstest.domain.jobsearch;

import com.chainbox.safaricom.careerstest.domain.Job;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SearchSpecificationBuilder {

    private final List<SearchCriteria> params;

    public SearchSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public SearchSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key,operation,value));
        return this;
    }

    public Specification<Job> build(){
        if(params.size()==0) return null;

        List<Specification<Job>> specifications = new ArrayList<Specification<Job>>();

        for(SearchCriteria param:params) specifications.add(new SearchSpecifications(param));

        Specification<Job> jobSpecification=specifications.get(0);
        for(int i=1;i<specifications.size();i++){
            jobSpecification = Specification.where(jobSpecification).and(specifications.get(i));
        }

        return jobSpecification;
    }
}
