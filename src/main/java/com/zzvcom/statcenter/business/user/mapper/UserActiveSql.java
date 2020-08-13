package com.zzvcom.statcenter.business.user.mapper;

import com.zzvcom.statcenter.base.utils.StrFormatter;
import com.zzvcom.statcenter.base.utils.StringUtilsLocal;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * @author boz
 * @date 2020/6/4
 */
@Slf4j
public class UserActiveSql {

    public static  String listAll(String startDate,String endDate,String province,String city,String area,String isDel,String schoolTypes,String activeType,String schoolId,int pageNo,int pageSize,int type){

        String sql_field = " ";
        String sql_fieldName = "";
        String sql_where = " ";
        String sql_table = "";

        String sql_where_end = "";
        if(StringUtilsLocal.isNotEmpty(area)){
            sql_field = "school_id";
            sql_fieldName = "school";
            sql_table = "d_school";
            sql_where += " and u.area_code = '" + area + "'";
            sql_where_end = " where bb.area_code = '" + area + "'";
        }else{
            if(StringUtilsLocal.isNotEmpty(city)){
                sql_field = "area_code ";
                sql_fieldName = "area ";
                sql_table = "d_area";
                sql_where += " and u.city_code = '" + city + "'";
                sql_where_end = " where bb.city_code = '" + city + "'";
            }else{
                if(StringUtilsLocal.isNotEmpty(province)){
                    sql_field = "city_code ";
                    sql_fieldName = "city ";
                    sql_table = "d_city";
                    sql_where += " and u.province_code = '" + province + "'";
                    sql_where_end = " where bb.province_code = '" + province + "'";
                }else{
                    sql_field = "province_code ";
                    sql_fieldName = "province ";
                    sql_table = "d_province";
                }
            }
        }

        //如果有学校id，则去掉区域的相关过滤条件
        if(StringUtilsLocal.isNotEmpty(schoolId)){
            sql_field = "class_id ";
            sql_fieldName = "class ";
            sql_table = "d_class";
            sql_where = " and u.school_id= '" + schoolId + "'";
            sql_where_end = " where bb.sch_id = '" + schoolId + "'";
        }

        if(StringUtilsLocal.isNotEmpty(startDate)){
            sql_where += " and a.active_time >= '" + startDate + "' ";
        }

        if(StringUtilsLocal.isNotEmpty(endDate)){
            sql_where += " and a.active_time <= '" + endDate + "' ";
        }

        if(StringUtilsLocal.isNotEmpty(activeType) && !"all".equals(activeType)){
            sql_where += " and a.login_source = '" + activeType + "' ";
        }


        if(StringUtilsLocal.isNotEmpty(isDel) && "0".equals(isDel)){
            sql_where += " and u.close_date > '" + LocalDate.now() +"' ";
        }

        if(StringUtilsLocal.isNotEmpty(schoolTypes)){
            //学校分类
            //1 正式  0 测试 2虚拟
            String[] schoolArr = schoolTypes.split(",");
//            String where = "";
            StringBuffer where = new StringBuffer("");
            for(String item : schoolArr){
                where.append(" u.sch_type = '" + item + "' or");
//                where += " u.sch_type = '" + item + "' or";
            }

            sql_where += " and ( " + StringUtilsLocal.trimEndStr(String.valueOf(where),"or") + " ) ";
        }


        String sql_base = "SELECT  COUNT (1) as {},u.{},u.{} FROM f_user_active a LEFT JOIN d_user u ON a.user_id = u.user_id WHERE a.is_first_active = '1' {} and u.user_type {}";

        String sql_student_where = StrFormatter.format(sql_base," s_count ",sql_fieldName,sql_field,sql_where," = '4' ") ;
        String sql_teacher_where = StrFormatter.format(sql_base," t_count ",sql_fieldName,sql_field,sql_where," in ('2','3') ") ;
        String sql_parent_where = StrFormatter.format(sql_base," p_count ",sql_fieldName,sql_field,sql_where," = '0' ") ;

        String sql_prefix = "";
        if(type == 1){
            sql_prefix = "select COALESCE(aa.sc,0) as sc,COALESCE(aa.tc,0) as tc,COALESCE(aa.pc,0) as pc,COALESCE(aa.allcount,0) as allcount,bb." + sql_fieldName + " as areaname from ";
        }else{
            sql_prefix = "select sum(COALESCE(aa.sc,0)) as sc,sum(COALESCE(aa.tc,0)) as tc,sum(COALESCE(aa.pc,0)) as pc,sum(COALESCE(aa.allcount,0)) as allcount from ";
        }

        String sql = sql_prefix +
                "(select " +
                " COALESCE(s1.s_count,0) as sc,COALESCE(s1.t_count,0) as tc,COALESCE(pc.p_count,0) as pc,(COALESCE(s1.s_count,0)+COALESCE(s1.t_count,0)+COALESCE(pc.p_count,0) )as allcount,s1."+sql_fieldName+" from " +
                " ( " +
                "    SELECT sc.s_count,tc.t_count,sc."+sql_field+",sc."+sql_fieldName+" from" +
                "        (  " + sql_student_where + " GROUP BY u."+sql_field+",u."+sql_fieldName+"  ) sc " +
                "           FULL JOIN " +
                "        (   " + sql_teacher_where + " GROUP BY u."+sql_field+",u."+sql_fieldName+") tc  " +
                "        ON sc."+sql_field+"=tc."+sql_field+
                " )  s1 " +
                " FULL JOIN " +
                " ( " + sql_parent_where + "  GROUP BY u."+sql_field+",u."+sql_fieldName+") pc " +
                " ON s1."+sql_field+"=pc."+sql_field + ") aa RIGHT JOIN "+ sql_table + " bb on aa." + sql_fieldName + " = bb." + sql_fieldName;


        sql += sql_where_end;

        log.info("sql:"+sql);
        return sql;
    }

    //分页查询数据
    public static String getListByPageSql(String startDate,String endDate,String province,String city,String area,String isDel,String schoolTypes,String activeType,String schoolId,int pageNo,int pageSize){
        String sql = listAll(startDate,endDate,province,city,area,isDel,schoolTypes,activeType,schoolId,pageNo,pageSize,1);
        String countSql = sql + " limit "+pageSize + " offset " + (pageNo - 1)*pageSize;
        return countSql;
    }

    //查询总和数据
    public static String getSumSql(String startDate,String endDate,String province,String city,String area,String isDel,String schoolTypes,String activeType,String schoolId,int pageNo,int pageSize){
        String sql = listAll(startDate,endDate,province,city,area,isDel,schoolTypes,activeType,schoolId,pageNo,pageSize,2);
        return sql;
    }


    public static String getCountSql(String startDate,String endDate,String province,String city,String area,String isDel,String schoolTypes,String activeType,String schoolId,int pageNo,int pageSize){

        String sql = "";
        //如果有学校id，则去掉区域的相关过滤条件
        if(StringUtilsLocal.isNotEmpty(schoolId)){
            //查询到班级
            sql = "select count(1) from d_class where sch_id='" + schoolId + "'";
        }else{
            if(StringUtilsLocal.isNotEmpty(area)){
                //查询到学校
                sql = "select count(1) from d_school where area_code='" + area + "'";
            }else{
                if(StringUtilsLocal.isNotEmpty(city)){
                    //查询到区域
                    sql = "select count(1) from d_area where city_code='" + city + "'";
                }else{
                    if(StringUtilsLocal.isNotEmpty(province)){
                        //查询到市
                        sql = "select count(1) from d_city where province_code ='" + province + "'";
                    }else{
                        //查询到省
                        sql = "select count(1) from d_province";
                    }
                }
            }
        }
        return sql;
    }

}
