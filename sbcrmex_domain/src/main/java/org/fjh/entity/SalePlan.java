package org.fjh.entity;

import java.util.Date;

public class SalePlan {
    private String id;

    private Date createdate;

    private Date modifydate;

    private String cid;

    private String cuid;

    private String auid;

    private Date acreatedate;

    private String duid;

    private String dcreatedate;

    private Integer status;

    private String result;

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

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
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

    public Date getAcreatedate() {
        return acreatedate;
    }

    public void setAcreatedate(Date acreatedate) {
        this.acreatedate = acreatedate;
    }

    public String getDuid() {
        return duid;
    }

    public void setDuid(String duid) {
        this.duid = duid == null ? null : duid.trim();
    }

    public String getDcreatedate() {
        return dcreatedate;
    }

    public void setDcreatedate(String dcreatedate) {
        this.dcreatedate = dcreatedate == null ? null : dcreatedate.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}