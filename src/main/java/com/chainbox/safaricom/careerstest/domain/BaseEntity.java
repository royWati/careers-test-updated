package com.chainbox.safaricom.careerstest.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;

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

//    @Column(name = "uuid", updatable = false,unique = true, nullable = false)
//    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
//    private String uuid;

    @PrePersist
    public void prePersist() {
        this.dateCreated = ZonedDateTime.now();
        this.deleted = false;

    }
}
