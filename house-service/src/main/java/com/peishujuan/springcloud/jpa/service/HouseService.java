package com.peishujuan.springcloud.jpa.service;

import com.peishujuan.springcloud.jpa.entity.House;
import org.springframework.data.domain.Page;

public interface HouseService {

    Page list(Integer pageNum, Integer pageSize, House house,Integer rentSearch);
}
