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
//@EqualsAndHashCode(of = "testData_id")
//@Entity
//@Table(name = "TestData")
//public class TestData {
//
//    @Id
//    @Column(name = "testData_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "inputData")
//    private String inputData;
//
//    @Column(name = "outputData")
//    private String outputData;
//
//    @OneToMany(mappedBy = "testData")
//    private Set<TestData> testDataSet;
//}
