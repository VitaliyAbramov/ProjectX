package com.springbootapp.entity.postgres;//package com.springbootapp.entity.postgres;
//
//import com.springbootapp.entity._enum.Difficulty;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//import java.batch.Set;
//
//@Data
//@EqualsAndHashCode(of = "codingTask_id")
//@Entity
//@Table(name = "CodingTask")
//public class CodingTask {
//
//    @Id
//    @Column(name = "codingTask_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "module_id")
//    private Module module;
//
//    @Column(name = "question")
//    private String question;
//
//    @Column(name = "difficulty")
//    private Difficulty difficulty;
//
//    @OneToMany(mappedBy = "codingTask")
//    private Set<CodingTask> codingTasks;
//}
