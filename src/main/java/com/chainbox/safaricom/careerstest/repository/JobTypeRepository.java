package com.chainbox.safaricom.careerstest.repository;

import com.chainbox.safaricom.careerstest.domain.JobType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType, UUID> {
}
