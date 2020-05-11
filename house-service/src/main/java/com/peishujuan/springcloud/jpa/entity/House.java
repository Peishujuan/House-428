package com.peishujuan.springcloud.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@Table(name = "l_house",catalog = "1708d_senior5",schema = "1708d_senior5")
public class House implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String community;
    private Integer room;
    private Integer hall;
    private Integer toilet;
    private String orientation;
    private Integer decorate;
    @Column(length = 8,scale = 2)
    private BigDecimal rent;
    private String pic;
    @Lob
    private String introduction;

    private Integer provinceId;
    private Integer cityId;
    private Integer countyId;

    @Transient
    private List<Integer> districtIds;


    @ManyToOne
    @JoinColumn(name = "provinceId",insertable = false,updatable = false)
    private District province;

    @ManyToOne
    @JoinColumn(name = "cityId",insertable = false,updatable = false)
    private District city;

    @ManyToOne
    @JoinColumn(name = "countyId",insertable = false,updatable = false)
    private District county;


}
