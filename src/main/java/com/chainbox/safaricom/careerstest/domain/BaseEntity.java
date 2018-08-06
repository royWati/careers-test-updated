package com.chainbox.safaricom.careerstest.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Column(name = "date_column")
    private ZonedDateTime dateCreated;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @Version
    private long version;

    @PrePersist
    public void prePersist() {
        this.dateCreated = ZonedDateTime.now();
        this.deleted = false;
    }
}
