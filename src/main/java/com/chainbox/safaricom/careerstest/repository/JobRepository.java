package com.chainbox.safaricom.careerstest.repository;

import com.chainbox.safaricom.careerstest.domain.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID>,JpaSpecificationExecutor<Job> {

}
