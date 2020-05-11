package com.peishujuan.springcloud.jpa.service.Impl;

import com.peishujuan.springcloud.jpa.dao.DistrictRepository;
import com.peishujuan.springcloud.jpa.dao.HouseRepository;
import com.peishujuan.springcloud.jpa.entity.House;
import com.peishujuan.springcloud.jpa.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Page list(Integer pageNum, Integer pageSize, House house, Integer rentSearch) {
        Specification<House> specification = new Specification<House>() {

            @Override
            public Predicate toPredicate(Root<House> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //保存一个集合

                List<Predicate> predicates = new ArrayList<>();
                //条件判断  对地区进行查询
                if (!StringUtils.isEmpty(house.getCountyId())) {
                    Predicate countyId = criteriaBuilder.equal(root.get("countyId"), house.getCountyId());
                    predicates.add(countyId);
                }

                //对厅室进行查询
                if (!StringUtils.isEmpty(house.getRoom())) {
                    Predicate countryId = criteriaBuilder.equal(root.get("room"), house.getRoom());
                    predicates.add(countryId);
                }

                //对房屋租金进行查询
                if (!StringUtils.isEmpty(rentSearch) && rentSearch == 1) {
                    Predicate countryId = criteriaBuilder.between(root.get("rent"), 600, 999);
                    predicates.add(countryId);
                }

                if (!StringUtils.isEmpty(rentSearch) && rentSearch == 2) {
                    Predicate countryId = criteriaBuilder.between(root.get("rent"), 1000, 1499);
                    predicates.add(countryId);
                }

                if (!StringUtils.isEmpty(rentSearch) && rentSearch == 3) {
                    Predicate countryId = criteriaBuilder.between(root.get("rent"), 1500, 1999);
                    predicates.add(countryId);
                }

                if (!StringUtils.isEmpty(rentSearch) && rentSearch == 4) {
                    Predicate countryId = criteriaBuilder.between(root.get("rent"), 2000, 2999);
                    predicates.add(countryId);
                }

                if (!StringUtils.isEmpty(rentSearch) && rentSearch == 5) {
                    Predicate countryId = criteriaBuilder.between(root.get("rent"), 3000, 4999);
                    predicates.add(countryId);
                }

                if (!StringUtils.isEmpty(rentSearch) && rentSearch == 6) {
                    Predicate countryId = criteriaBuilder.between(root.get("rent"), 5000, 8000);
                    predicates.add(countryId);
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }


        };
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return houseRepository.findAll(specification, pageable);
    }
}
