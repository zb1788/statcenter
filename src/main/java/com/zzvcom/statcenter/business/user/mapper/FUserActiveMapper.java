package com.zzvcom.statcenter.business.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzvcom.statcenter.business.user.entity.FUserActive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author boz
 * @since 2020-06-02
 */
@Mapper
@Component
public interface FUserActiveMapper extends BaseMapper<FUserActive> {


    @SelectProvider(type = UserActiveSql.class,method = "getListByPageSql")
    public List<Map> getUserActive(String startDate,String endDate,String province,String city,String area,String isDel,String schoolTypes,String activeType,String schoolId,int pageNo,int pageSize);


    @SelectProvider(type = UserActiveSql.class,method = "getCountSql")
    public int getUserActiveTotal(String startDate,String endDate,String province,String city,String area,String isDel,String schoolTypes,String activeType,String schoolId,int pageNo,int pageSize);


    @SelectProvider(type = UserActiveSql.class,method = "getSumSql")
    public List<Map> getUserActiveSum(String startDate,String endDate,String province,String city,String area,String isDel,String schoolTypes,String activeType,String schoolId,int pageNo,int pageSize);


}
