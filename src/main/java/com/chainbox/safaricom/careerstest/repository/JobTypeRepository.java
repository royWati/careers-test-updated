package com.chainbox.safaricom.careerstest.repository;

import com.chainbox.safaricom.careerstest.domain.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType, Long> {
    Optional<JobType> findById(Long id);
    Optional<JobType> findJobTypeByUuid(String uuid);
}
