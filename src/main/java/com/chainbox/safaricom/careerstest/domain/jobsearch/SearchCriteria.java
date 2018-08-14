package com.chainbox.safaricom.careerstest.domain.jobsearch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;


    public SearchCriteria(String key, String operation, Object value) {
    }
}
