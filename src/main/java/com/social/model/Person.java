package com.social.model;

import com.social.validation.MatchPassword;
import com.social.validation.UniqueEmail;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@MatchPassword
public class Person extends ParentEntity {

    @Getter
    @Setter
    @Size(min = 3)
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Size(min = 3)
    @Column(name = "last_name")
    private String lastName;

    @Column
    @Getter
    @Setter
    @Size
    private String surname;

    @Email
    @Getter
    @Setter
    @UniqueEmail
    @Column(unique = true)
    private String email;

    @Column
    @Getter
    @Setter
    @NotBlank
    private String password;

    @Getter
    @Setter
    @Transient
    @Size(min = 6, max = 36)
    private String rawPassword;

    @Getter
    @Setter
    @Column(name = "unique_name")
    private String uniqueName;

    @Column
    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.ACTIVE;

    @Column
    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    private Role role = Role.USER;

    public enum Role {
        ANONYMOUS, ADMIN, USER
    }

    public enum Status {
        ACTIVE, INACTIVE, BLOCKED
    }
}