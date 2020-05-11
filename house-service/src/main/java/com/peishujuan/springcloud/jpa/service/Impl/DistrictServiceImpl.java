package com.peishujuan.springcloud.jpa.service.Impl;

import com.peishujuan.springcloud.jpa.dao.DistrictRepository;
import com.peishujuan.springcloud.jpa.entity.District;
import com.peishujuan.springcloud.jpa.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

//    @Override
//    public List<District> getList() {
//        //一次从数据查询的所有数据
//        List<District> all = districtRepository.findAll();
//        List<District> provinceList = districtRepository.findByPid(1);
//        //从all里查询省的数据
//        all.forEach(province ->{
//            if(province.getPid()==1){
//                provinceList.add(province);
//            }
//        });
//        //遍历省 查找市的数据
//        provinceList.forEach(province->{
//            //查省下的所有市
//            List<District> cityList = new ArrayList<>();
//            all.forEach(city->{
//                if(city.getPid().intValue()==province.getId().intValue()){
//                    cityList.add(city);
//                    //查市下的所有区
//                    List<District> countryList = new ArrayList<>();
//                    all.forEach(country->{
//                        if(country.getPid().intValue()==city.getId().intValue()){
//                            countryList.add(country);
//                        }
//                    });
//                    //设置区
//                    city.setDistrictList(countryList);
//                }
//            });
//            //设置市
//            province.setDistrictList(cityList);
//        });
//        return provinceList;
//    }
@Override
public List<District> getList() {
    List<District> all = districtRepository.findAll();
    List<District> provinceList = districtRepository.findByPid(1);
    provinceList.forEach(province->{
        List<District> cityList=new ArrayList<>();
        all.forEach(city->{
            if (province.getId().intValue()==city.getPid().intValue()){
                cityList.add(city);
                List<District> countryList=new ArrayList<>();
                all.forEach(country->{
                    if (city.getId().intValue()==country.getPid().intValue()){
                        countryList.add(country);
                    }
                });
                city.setDistrictList(countryList);
            }
        });
        province.setDistrictList(cityList);
    });
    return provinceList;
}


    @Override
    public List<District> getListByPid() {
        return districtRepository.findByPid(33);
    }
}
