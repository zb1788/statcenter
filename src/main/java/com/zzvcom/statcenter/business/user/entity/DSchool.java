package com.zzvcom.statcenter.business.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author boz
 * @since 2020-06-05
 */
public class DSchool implements Serializable {

    private static final long serialVersionUID=1L;

    private String schId;

    /**
     * 平台编码
     */
    private String platCode;

    /**
     * 平台
     */
    private String plat;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省
     */
    private String province;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 市
     */
    private String city;

    /**
     * 区县编码
     */
    private String areaCode;

    /**
     * 区县
     */
    private String area;

    /**
     * 乡镇编码
     */
    private String townCode;

    /**
     * 乡镇
     */
    private String town;

    /**
     * 学校
     */
    private String school;

    /**
     * 直属层级：省直属、市直属、区县直属
     */
    private String directlyUnder;

    /**
     * 学校类型：正式、虚拟、测试 
     */
    private String type;

    /**
     * 学段类别:幼儿园、小学、初中、高中、9年一贯制
     */
    private String periodKind;

    private  LocalDateTime endTime;
    private  LocalDateTime dsLoadTime;

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getDsLoadTime() {
        return dsLoadTime;
    }

    public void setDsLoadTime(LocalDateTime dsLoadTime) {
        this.dsLoadTime = dsLoadTime;
    }

    private String dsDeleteFlag;


    public String getSchId() {
        return schId;
    }

    public void setSchId(String schId) {
        this.schId = schId;
    }

    public String getPlatCode() {
        return platCode;
    }

    public void setPlatCode(String platCode) {
        this.platCode = platCode;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDirectlyUnder() {
        return directlyUnder;
    }

    public void setDirectlyUnder(String directlyUnder) {
        this.directlyUnder = directlyUnder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriodKind() {
        return periodKind;
    }

    public void setPeriodKind(String periodKind) {
        this.periodKind = periodKind;
    }


    public String getDsDeleteFlag() {
        return dsDeleteFlag;
    }

    public void setDsDeleteFlag(String dsDeleteFlag) {
        this.dsDeleteFlag = dsDeleteFlag;
    }

    @Override
    public String toString() {
        return "DSchool{" +
                "schId='" + schId + '\'' +
                ", platCode='" + platCode + '\'' +
                ", plat='" + plat + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", province='" + province + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", city='" + city + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", area='" + area + '\'' +
                ", townCode='" + townCode + '\'' +
                ", town='" + town + '\'' +
                ", school='" + school + '\'' +
                ", directlyUnder='" + directlyUnder + '\'' +
                ", type='" + type + '\'' +
                ", periodKind='" + periodKind + '\'' +
                ", endTime=" + endTime +
                ", dsLoadTime=" + dsLoadTime +
                ", dsDeleteFlag='" + dsDeleteFlag + '\'' +
                '}';
    }
}
