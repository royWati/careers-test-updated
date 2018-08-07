package com.chainbox.safaricom.careerstest.repository;

import com.chainbox.safaricom.careerstest.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
