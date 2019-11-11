package com.springbootapp.entity.postgres;//package com.springbootapp.entity.postgres;
//
//import com.springbootapp.entity.postgres.id.StatisticId;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import javax.persistence.*;
//
//@Data
//@EqualsAndHashCode(of = "statisticId")
//@Entity
//@Table(name = "Statistic")
//public class Statistic {
//
//    @EmbeddedId
//    private StatisticId statisticId;
//
//    @ManyToOne
//    @MapsId("user_id")
//    private User user;
//
//    @ManyToOne
//    @MapsId("module_id")
//    private Module module;
//}
