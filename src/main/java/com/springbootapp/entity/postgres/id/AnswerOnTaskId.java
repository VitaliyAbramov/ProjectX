package com.springbootapp.entity.postgres.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOnTaskId implements Serializable {

    @Column(name = "codingTask_id")
    private int codingTaskId;

    @Column(name = "answer_id")
    private int answerId;
}
