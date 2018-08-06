package com.chainbox.safaricom.careerstest.controller;


import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import com.chainbox.safaricom.careerstest.domain.vo.Success;
import com.chainbox.safaricom.careerstest.domain.vo.UpdateResponse;
import com.chainbox.safaricom.careerstest.service.jobApplicantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class jobApplicants {

    @Autowired
    private jobApplicantService job_service;


    @RequestMapping(value = "applications/add", method = RequestMethod.POST)

    public List<Success> addApplicant(@RequestBody JobApplicant applicants) {

        return job_service.add_applicant(applicants);
    }


    @RequestMapping(value = "/applications/all", method = RequestMethod.GET)

    public List<JobApplicant> getAllApplicants() {

        return job_service.all_applicants();
    }


    @RequestMapping(value = "applications/update/", method = RequestMethod.PUT)
    public List<UpdateResponse> update_user_information(@RequestBody JobApplicant applicants) {

        return job_service.update_user_information(applicants);
    }

//    @RequestMapping(method = RequestMethod.DELETE, value = "applications/delete/{id}")
//    public List<Success> deleteApplicant(@PathVariable int id) {
//        return job_service.deleteApplicant(id);
//    }


    @RequestMapping(method = RequestMethod.GET, value = "applications/getone/{id}")
    public List<JobApplicant> getOneApplication(@PathVariable int id) {
        return job_service.get_one_job_applicant(id);
    }


}
