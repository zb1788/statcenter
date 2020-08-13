package com.zzvcom.statcenter.business.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzvcom.statcenter.business.user.entity.DArea;
import com.zzvcom.statcenter.business.user.service.DAreaService;
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
@RequestMapping("/user/area")
public class DAreaController {

    @Autowired
    DAreaService dAreaService;

    @GetMapping("getAreaList/{cityCode}")
    public ResponseEntity<ResponseWrapper<List<DArea>>> getAreaListByCity(@PathVariable String cityCode){
        QueryWrapper<DArea> queryWrapper = new QueryWrapper<>();
        List<DArea> list = dAreaService.list(queryWrapper.eq("city_code", cityCode));
        return WrapResponseMapper.ok(list);
    }


    @GetMapping("getAreaById/{areaCode}")
    public ResponseEntity<ResponseWrapper<List<DArea>>> getAreaById(@PathVariable String areaCode){
        QueryWrapper<DArea> queryWrapper = new QueryWrapper<>();
        List<DArea> list = dAreaService.list(queryWrapper.eq("area_code", areaCode));
        return WrapResponseMapper.ok(list);
    }
}

