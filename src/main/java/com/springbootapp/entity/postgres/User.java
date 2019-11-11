package com.springbootapp.entity.postgres;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * User entity which represent the all users of the system.
 *
 * @version 1.0
 * @author vabram
 */
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "test_user")
public class User extends DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

//    @ManyToMany(mappedBy = "users")
//    private Set<Module> modules;
//
//    @OneToMany(mappedBy = "user")
//    private Set<ValidationTest> validationTests;
}
