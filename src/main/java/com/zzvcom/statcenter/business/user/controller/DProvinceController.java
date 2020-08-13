package com.zzvcom.statcenter.business.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzvcom.statcenter.business.user.entity.DProvince;
import com.zzvcom.statcenter.business.user.service.DProvinceService;
import com.zzvcom.wrapper.ResponseWrapper;
import com.zzvcom.wrapper.WrapResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user/province")
public class DProvinceController {


    @Autowired
    DProvinceService dProvinceService;

    @GetMapping("getProvinceList")
    public ResponseEntity<ResponseWrapper<List<DProvince>>> getProvinceList(@RequestParam("fid") String areaId){
        List<DProvince> list = null;
        if("".equals(areaId)){
            list = dProvinceService.list();
        }else{
            QueryWrapper<DProvince> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("province_code",areaId);
            list = dProvinceService.list(queryWrapper);
        }

        return WrapResponseMapper.ok(list);
    }

}

