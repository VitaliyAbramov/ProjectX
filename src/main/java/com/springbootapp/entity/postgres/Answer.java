package com.springbootapp.entity.postgres;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "Answer")
public class Answer extends DataEntity {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "answer")
    private String answer;
}
