package com.springbootapp.entity.postgres;//package com.springbootapp.entity.postgres;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//
//@Data
//@EqualsAndHashCode(of = "validationTest_id")
//@Entity
//@Table(name = "validationTest")
//public class ValidationTest {
//
//    @Id
//    @Column(name = "validationTest_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "codingTask_id")
//    private CodingTask codingTask;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "testData_id")
//    private TestData testData;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//}
