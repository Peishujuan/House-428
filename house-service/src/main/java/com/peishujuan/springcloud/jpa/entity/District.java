package com.peishujuan.springcloud.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "l_district",catalog = "1708d_senior5",schema = "1708d_senior5")
public class District implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer pid;

    @Transient
    private List<District> districtList;
}
