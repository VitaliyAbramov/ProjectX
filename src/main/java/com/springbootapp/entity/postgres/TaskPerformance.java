package com.springbootapp.entity.postgres;//package com.springbootapp.entity.postgres;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//import java.batch.Set;
//
//@Data
//@EqualsAndHashCode(of = "taskPerformance_id")
//@Entity
//@Table(name = "taskPerformance")
//public class TaskPerformance {
//
//    @Id
//    @Column(name = "taskPerformance_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @OneToMany(mappedBy = "taskPerformance")
//    private Set<ValidationTest> validationTests;
//
//    @Column(name = "performanceScore")
//    private String performanceScore;
//}
