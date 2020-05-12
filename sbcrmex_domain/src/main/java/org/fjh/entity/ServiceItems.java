package org.fjh.entity;

import java.util.Date;

public class ServiceItems {
    private String id;

    private Date createdate;

    private Date updatedate;

    private String sid;

    private String auid;

    private Date acreatedate;

    private String amemo;

    private String duid;

    private Date dcreatedate;

    private String dresult;


    private User fduser;//分配者
    private User duser;//实施者

    public User getFduser() {
        return fduser;
    }

    public void setFduser(User fduser) {
        this.fduser = fduser;
    }

    public User getDuser() {
        return duser;
    }

    public void setDuser(User duser) {
        this.duser = duser;
    }

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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
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

    public String getAmemo() {
        return amemo;
    }

    public void setAmemo(String amemo) {
        this.amemo = amemo == null ? null : amemo.trim();
    }

    public String getDuid() {
        return duid;
    }

    public void setDuid(String duid) {
        this.duid = duid == null ? null : duid.trim();
    }

    public Date getDcreatedate() {
        return dcreatedate;
    }

    public void setDcreatedate(Date dcreatedate) {
        this.dcreatedate = dcreatedate;
    }

    public String getDresult() {
        return dresult;
    }

    public void setDresult(String dresult) {
        this.dresult = dresult == null ? null : dresult.trim();
    }
}