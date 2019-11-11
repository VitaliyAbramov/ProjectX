package com.springbootapp.entity.postgres;//package com.springbootapp.entity.postgres;
//
//import com.springbootapp.entity.postgres.id.AnswerOnTaskId;
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Table(name = "AnswerOnTask")
//public class AnswerOnTask {
//
//    @EmbeddedId
//    private AnswerOnTaskId answerOnTaskId;
//
//    @ManyToOne
//    @MapsId("codingTask_id")
//    private CodingTask codingTask;
//
//    @ManyToOne
//    @MapsId("answer_id")
//    private Answer answer;
//}
