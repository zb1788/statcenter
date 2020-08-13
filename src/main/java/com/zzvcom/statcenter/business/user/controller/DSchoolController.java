package com.zzvcom.statcenter.business.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzvcom.statcenter.business.user.entity.DSchool;
import com.zzvcom.statcenter.business.user.service.DSchoolService;
import com.zzvcom.wrapper.ResponseWrapper;
import com.zzvcom.wrapper.WrapResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author boz
 * @since 2020-06-05
 */
@RestController
@RequestMapping("/user/school")
public class DSchoolController {

    @Autowired
    DSchoolService dSchoolService;

    @GetMapping("/schoolList/{schoolName}")
    public ResponseEntity<ResponseWrapper<List<DSchool>>> getSchoolByName(@PathVariable String schoolName){
        LocalDateTime date = LocalDateTime.now();
        QueryWrapper<DSchool> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("school",schoolName).and(i->i.gt("end_time",date));

        List<DSchool> list = dSchoolService.list(queryWrapper);
        return WrapResponseMapper.ok(list);
    }
}

