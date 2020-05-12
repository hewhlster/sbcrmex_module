package org.fjh.entity;

import java.util.Date;

public class SaleChance {
    private String id;

    private Date createdate;

    private Date updatedate;

    private String source;

    private String cname;

    private String lname;

    private String ltel1;

    private String ltel2;

    private String caddr;

    private String summay;

    private String detail;

    private String cuid;

    private String auid;

    private String duid;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public String getLtel1() {
        return ltel1;
    }

    public void setLtel1(String ltel1) {
        this.ltel1 = ltel1 == null ? null : ltel1.trim();
    }

    public String getLtel2() {
        return ltel2;
    }

    public void setLtel2(String ltel2) {
        this.ltel2 = ltel2 == null ? null : ltel2.trim();
    }

    public String getCaddr() {
        return caddr;
    }

    public void setCaddr(String caddr) {
        this.caddr = caddr == null ? null : caddr.trim();
    }

    public String getSummay() {
        return summay;
    }

    public void setSummay(String summay) {
        this.summay = summay == null ? null : summay.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid == null ? null : cuid.trim();
    }

    public String getAuid() {
        return auid;
    }

    public void setAuid(String auid) {
        this.auid = auid == null ? null : auid.trim();
    }

    public String getDuid() {
        return duid;
    }

    public void setDuid(String duid) {
        this.duid = duid == null ? null : duid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}