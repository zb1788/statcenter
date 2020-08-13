package com.zzvcom.statcenter.business.user.controller;


import com.zzvcom.statcenter.business.user.mapper.FUserActiveMapper;
import com.zzvcom.wrapper.PageData;
import com.zzvcom.wrapper.ResponseWrapper;
import com.zzvcom.wrapper.WrapResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author boz
 * @since 2020-06-02
 */
@RestController
@RequestMapping("/user/active")
public class FUserActiveController {

    @Autowired
    FUserActiveMapper fUserActiveMapper;


    @PostMapping("list")
    public ResponseEntity<ResponseWrapper<PageData<Map>>> list(@RequestParam("activeType") String activeType,
                                                               @RequestParam("startDate") String startDate,
                                                               @RequestParam("endDate") String endDate,
                                                               @RequestParam("province") String province,
                                                               @RequestParam("city") String city,
                                                               @RequestParam("area") String area,
//                           @RequestParam("userType") String userType,
                                                               @RequestParam("isDel") String isDel,
                                                               @RequestParam("schoolTypes") String schoolTypes,
                                                               @RequestParam("schoolId") String schoolId,
                                                               @RequestParam("pageNo") int pageNo,
                                                               @RequestParam("pageSize") int pageSize){
        //按条件查询每个分组的数量
        List<Map> userActive = fUserActiveMapper.getUserActive(startDate,endDate,province,city,area,isDel,schoolTypes,activeType,schoolId,pageNo,pageSize);
        //按条件查询每个分组的总和
        List<Map> userActiveSum = fUserActiveMapper.getUserActiveSum(startDate, endDate, province, city, area, isDel, schoolTypes, activeType, schoolId, pageNo, pageSize);

        if(userActiveSum.get(0) == null){
            userActiveSum.clear();
            Map map = new HashMap();
            map.put("sc",0);
            map.put("tc",0);
            map.put("pc",0);
            map.put("allcount",0);
            userActiveSum.add(map);
        }
        userActiveSum.get(0).put("areaname","汇总");
        //汇总和单个数据合并
        userActiveSum.addAll(userActive);

        int userActiveTotal = fUserActiveMapper.getUserActiveTotal(startDate, endDate, province, city, area, isDel, schoolTypes, activeType, schoolId, pageNo, pageSize);

        return WrapResponseMapper.ok(PageData.of(userActiveSum,userActiveTotal,pageNo,pageSize));
    }
}

