package com.zzvcom.statcenter.business.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("f_user_active")
public class FUserActive implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 关联用户维度
     */
    private String userId;

    /**
     * 激活日期
     */
    private LocalDateTime activeTime;

    /**
     * 激活入口，优教助手（PC端）、优教授课（授课端）、优教信使
     */
    private String loginSource;

    /**
     * 是否首次激活
     */
    private String isFirstActive;

    /**
     * 是否父母激活
     */
    private String isParentActive;

    private LocalDateTime dsLoadTime;

    private String dsDeleteFlag;

    private String userType;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(LocalDateTime activeTime) {
        this.activeTime = activeTime;
    }

    public String getLoginSource() {
        return loginSource;
    }

    public void setLoginSource(String loginSource) {
        this.loginSource = loginSource;
    }

    public String getIsFirstActive() {
        return isFirstActive;
    }

    public void setIsFirstActive(String isFirstActive) {
        this.isFirstActive = isFirstActive;
    }

    public String getIsParentActive() {
        return isParentActive;
    }

    public void setIsParentActive(String isParentActive) {
        this.isParentActive = isParentActive;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "FUserActive{" +
        "userId=" + userId +
        ", activeTime=" + activeTime +
        ", loginSource=" + loginSource +
        ", isFirstActive=" + isFirstActive +
        ", isParentActive=" + isParentActive +
        ", dsLoadTime=" + dsLoadTime +
        ", dsDeleteFlag=" + dsDeleteFlag +
        ", userType=" + userType +
        "}";
    }
}
