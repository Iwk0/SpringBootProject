package com.social.model;

import com.social.validation.MatchPassword;
import com.social.validation.UniqueEmail;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;

@SqlResultSetMapping(name="PersonResult",
        entities={
                @EntityResult(entityClass=Person.class, fields={
                        @FieldResult(name="firstName", column="first_name"),
                        @FieldResult(name="dateCreated", column="date_created"),
                        @FieldResult(name="dateLastModified", column="date_last_modified"),
                        @FieldResult(name="lastName", column="last_name"),
                        @FieldResult(name="surname", column="surname"),
                        @FieldResult(name="email", column="email"),
                        @FieldResult(name="password", column="password"),
                        @FieldResult(name="uniqueName", column="unique_name"),
                        @FieldResult(name="status", column="status"),
                        @FieldResult(name="role", column="role"),
                        @FieldResult(name="id", column="id")})}
)
@NamedNativeQuery(name = "Person.findAllPersons", query = "select id as id, first_name as first_name, date_created as date_created, " +
        "date_last_modified as date_last_modified, last_name as last_name, 'pass' as password, surname as surname, email as email, unique_name as unique_name, status as status, role as role from person", resultSetMapping = "PersonResult")
@Entity
@MatchPassword
public class Person extends ParentEntity {

    @Getter
    @Setter
    @Size(min = 3, max = 40)
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Size(min = 3, max = 40)
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
    @Size(min = 3, max = 40)
    @UniqueEmail
    @Column(unique = true)
    private String email;

    @Column
    @Getter
    @Setter
    @Size(min = 6, max = 36)
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