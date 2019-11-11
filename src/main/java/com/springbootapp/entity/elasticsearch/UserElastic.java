package com.springbootapp.entity.elasticsearch;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@Document(indexName = "my_index", type = "TEST_USER")
public class UserElastic {

    @Id
    private Long id;

    @Field
    private String firstName;

    @Field
    private String lastName;

    @Field
    private LocalDate birthday;

    @Field
    private String email;

    @Field
    private String phone;

    @Field
    private String country;

    @Field
    private String city;

    @Field
    private String login;

    @Field
    private String password;
}
