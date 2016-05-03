package com.social.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EqualsAndHashCode(exclude = {"dateCreated", "dateLastModified"})
public class ParentEntity implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    @Getter
    @Setter
    @Column(name = "date_created")
    private Date dateCreated;

    @Getter
    @Setter
    @Column(name = "date_last_modified")
    private Date dateLastModified;

    @PreUpdate
    public void preUpdate() {
        this.dateLastModified = new Date();
    }

    @PrePersist
    public void perCreate() {
        this.dateCreated = new Date();
    }
}