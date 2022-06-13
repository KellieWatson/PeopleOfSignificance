package com.watsonxyz.kd.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractEntity implements Comparable<AbstractEntity>{
    @Id
    @GeneratedValue
    private int id;
}

