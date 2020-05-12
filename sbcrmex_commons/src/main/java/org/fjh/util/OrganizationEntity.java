package org.fjh.util;

/**
 * 作用：
 * 版本信息：
 * 日期：2019年1月18日-上午12:06:52
 * 版权:樊建华
 */

public class OrganizationEntity {
    public String parentId;
    public String orgId;
    public String orgName;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

}  