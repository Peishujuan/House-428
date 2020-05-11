package com.peishujuan.springcloud.jpa.controller;


import com.peishujuan.springcloud.jpa.dao.DistrictRepository;
import com.peishujuan.springcloud.jpa.entity.District;
import com.peishujuan.springcloud.jpa.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author peishujuan
 * @since 2020-04-28
 */
@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("getList")
    public List<District> getList(){
        return districtService.getList();
    }

    @RequestMapping("getListByPid")
    public List<District> getListByPid(){
        return districtService.getListByPid();
    }
}

