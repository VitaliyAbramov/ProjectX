package com.springbootapp.entity.postgres;//package com.springbootapp.entity.postgres;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//import java.batch.Set;
//
///**
// * Module entity which represent the modules of Java Core.
// *
// * @author vabram
// * @version 1.0
// */
//@Data
//@EqualsAndHashCode(of = "id")
//@Entity
//@Table(name = "Module")
//public class Module {
//
//    @Id
//    @Column(name = "module_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "module")
//    private String module;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "statistic",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"))
//    private Set<User> users;
//
//    @OneToMany(mappedBy = "module")
//    private Set<CodingTask> codingTasks;
//}
