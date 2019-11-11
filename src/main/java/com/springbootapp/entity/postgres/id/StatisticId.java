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
public class StatisticId implements Serializable {

    @Column(name = "user_id")
    private int userid;

    @Column(name = "module_id")
    private int moduleid;
}
