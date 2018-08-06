package com.chainbox.safaricom.careerstest.domain.vo;

import java.util.List;

public class UpdateResponse {

    public List<Success> successes;
    public List applicants;

    public UpdateResponse(List<Success> successes, List applicants) {
        this.successes = successes;
        this.applicants = applicants;
    }
}
