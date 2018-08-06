package com.chainbox.safaricom.careerstest.repository;

import com.chainbox.safaricom.careerstest.domain.Applications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource(path = "job-applications/details", rel = "Applications")
public interface application_interface extends JpaRepository<Applications, Integer> {
}
