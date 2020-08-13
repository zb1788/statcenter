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
public class DCity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    private LocalDateTime dsLoadTime;

    private String dsDeleteFlag;


    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        return "DCity{" +
        "cityCode=" + cityCode +
        ", provinceCode=" + provinceCode +
        ", province=" + province +
        ", city=" + city +
        ", dsLoadTime=" + dsLoadTime +
        ", dsDeleteFlag=" + dsDeleteFlag +
        "}";
    }
}
