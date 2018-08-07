package com.chainbox.safaricom.careerstest.repository;

import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface applicantsRepository extends JpaRepository<JobApplicant, Long> {


}
