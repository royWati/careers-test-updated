package com.chainbox.safaricom.careerstest.repository;

import com.chainbox.safaricom.careerstest.domain.JobApplicant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface JobApplicantRepository extends JpaRepository<JobApplicant, UUID> {
}
