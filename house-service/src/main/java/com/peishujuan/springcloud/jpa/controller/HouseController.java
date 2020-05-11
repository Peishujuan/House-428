package com.peishujuan.springcloud.jpa.controller;


import com.peishujuan.springcloud.jpa.dao.HouseRepository;
import com.peishujuan.springcloud.jpa.entity.House;
import com.peishujuan.springcloud.jpa.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author peishujuan
 * @since 2020-04-28
 */
@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseRepository houseRepository;

    @RequestMapping("findAll")
    public Page<House> findAll(@RequestParam(defaultValue = "1")Integer pageNum,
                               @RequestParam(defaultValue = "3")Integer pageSize,
                               House house, Integer rentSearch){

        return houseService.list(pageNum, pageSize, house, rentSearch);
    }

    @RequestMapping("insert")
    public House insert(@RequestBody House house){
        return houseRepository.save(house);

    }

    @RequestMapping("update")
    public House update(@RequestBody House house){
        return houseRepository.saveAndFlush(house);
    }

    @RequestMapping("delete")
    public int delete(Integer[] ids){
        for (Integer id:ids){
            houseRepository.deleteById(id);
        }
        return 1;
    }
}

