package com.peishujuan.springcloud.jpa.dao;

import com.peishujuan.springcloud.jpa.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author peishujuan
 * @since 2020-04-28
 */
public interface HouseRepository extends JpaRepository<House,Integer>, JpaSpecificationExecutor<House> {

}
