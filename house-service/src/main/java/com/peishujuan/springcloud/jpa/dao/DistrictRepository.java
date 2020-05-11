package com.peishujuan.springcloud.jpa.dao;

import com.peishujuan.springcloud.jpa.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author peishujuan
 * @since 2020-04-28
 */
public interface DistrictRepository extends JpaRepository<District,Integer> {

    //根据pid查询地区
    List<District> findByPid(Integer pid);

}
