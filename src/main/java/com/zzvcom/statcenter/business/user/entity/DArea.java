package com.zzvcom.statcenter.business.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author boz
 * @since 2020-06-02
 */
public class DArea implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 区县编码
     */
    private String areaCode;

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
     * 区县
     */
    private String area;

    private LocalDateTime dsLoadTime;

    private String dsDeleteFlag;


    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDateTime getDsLoadTime() {
        return dsLoadTime;
    }

    public void setDsLoadTime(LocalDateTime dsLoadTime) {
        this.dsLoadTime = dsLoadTime;
    }

    public String getDsDeleteFlag() {
        return dsDeleteFlag;
    }

    public void setDsDeleteFlag(String dsDeleteFlag) {
        this.dsDeleteFlag = dsDeleteFlag;
    }

    @Override
    public String toString() {
        return "DArea{" +
        "areaCode=" + areaCode +
        ", provinceCode=" + provinceCode +
        ", province=" + province +
        ", cityCode=" + cityCode +
        ", city=" + city +
        ", area=" + area +
        ", dsLoadTime=" + dsLoadTime +
        ", dsDeleteFlag=" + dsDeleteFlag +
        "}";
    }
}
