package com.peishujuan.springcloud.jpa.service;

import com.peishujuan.springcloud.jpa.entity.District;

import java.util.List;

public interface DistrictService {
    List<District> getList();
    List<District> getListByPid();
}
