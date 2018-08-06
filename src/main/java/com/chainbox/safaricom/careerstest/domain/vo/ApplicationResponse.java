package com.chainbox.safaricom.careerstest.domain.vo;

import com.chainbox.safaricom.careerstest.domain.Job;
import com.chainbox.safaricom.careerstest.domain.JobApplicant;

import java.util.ArrayList;
import java.util.List;

public class ApplicationResponse {


    public List<JobApplicant> applicant_information;
    public ArrayList<Job> jobsApplied;
    public int application_id;

    public ApplicationResponse(int application_id, List<JobApplicant> applicant_information, ArrayList<Job> jobsApplied) {
        this.application_id = application_id;
        this.applicant_information = applicant_information;
        this.jobsApplied = jobsApplied;

    }

    public List<JobApplicant> getApplicant_information() {
        return applicant_information;
    }

    public void setApplicant_information(List<JobApplicant> applicant_information) {
        this.applicant_information = applicant_information;
    }

    public ArrayList<Job> getJobsApplied() {
        return jobsApplied;
    }

    public void setJobsApplied(ArrayList<Job> jobsApplied) {
        this.jobsApplied = jobsApplied;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }
}
