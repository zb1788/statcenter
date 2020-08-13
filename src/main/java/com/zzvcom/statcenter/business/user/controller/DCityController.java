package com.zzvcom.statcenter.business.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzvcom.statcenter.business.user.entity.DCity;
import com.zzvcom.statcenter.business.user.service.DCityService;
import com.zzvcom.wrapper.ResponseWrapper;
import com.zzvcom.wrapper.WrapResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author boz
 * @since 2020-06-02
 */
@RestController
@RequestMapping("/user/city")
public class DCityController {

    @Autowired
    DCityService dCityService;

    @GetMapping("getCityList/{fid}")
    public ResponseEntity<ResponseWrapper<List<DCity>>> getCityList(@PathVariable String fid){
        QueryWrapper<DCity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("province_code",fid);
        List<DCity> list = dCityService.list(queryWrapper);
        return WrapResponseMapper.ok(list);
    }

    @GetMapping("getCityById/{fid}")
    public ResponseEntity<ResponseWrapper<List<DCity>>> getCityById(@PathVariable String fid){
        QueryWrapper<DCity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_code",fid);
        List<DCity> list = dCityService.list(queryWrapper);
        return WrapResponseMapper.ok(list);
    }

}

