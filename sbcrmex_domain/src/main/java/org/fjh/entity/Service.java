package org.fjh.entity;

import java.util.Date;
import java.util.List;

public class Service {
    private String id;

    private Date createdate;

    private Date modifydate;

    private String cid;

    private String stid;

    private String summary;

    private String status;

    private String detail;

    private String cuid;

    private String fauid;

    private Date facreatetime;

    private String fduid;

    private Date fdcreatetime;

    private String fresult;

    private Integer fsatisfy;

    private Customer customer;//服务的客户
    private User cuser;//创建者
    private User fauser;//服务满意调查指派者
    private User fduser;//服务满意调查实施者
    private List<ServiceItems> items;//具体服务项目

    public User getFduser() {
        return fduser;
    }

    public void setFduser(User fduser) {
        this.fduser = fduser;
    }

    public User getFauser() {
        return fauser;
    }

    public void setFauser(User fauser) {
        this.fauser = fauser;
    }

    public List<ServiceItems> getItems() {
        return items;
    }

    public void setItems(List<ServiceItems> items) {
        this.items = items;
    }

    public User getCuser() {
        return cuser;
    }

    public void setCuser(User cuser) {
        this.cuser = cuser;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getFauid() {
        return fauid;
    }

    public void setFauid(String fauid) {
        this.fauid = fauid == null ? null : fauid.trim();
    }

    public Date getFacreatetime() {
        return facreatetime;
    }

    public void setFacreatetime(Date facreatetime) {
        this.facreatetime = facreatetime;
    }

    public String getFduid() {
        return fduid;
    }

    public void setFduid(String fduid) {
        this.fduid = fduid == null ? null : fduid.trim();
    }

    public Date getFdcreatetime() {
        return fdcreatetime;
    }

    public void setFdcreatetime(Date fdcreatetime) {
        this.fdcreatetime = fdcreatetime;
    }

    public String getFresult() {
        return fresult;
    }

    public void setFresult(String fresult) {
        this.fresult = fresult == null ? null : fresult.trim();
    }

    public Integer getFsatisfy() {
        return fsatisfy;
    }

    public void setFsatisfy(Integer fsatisfy) {
        this.fsatisfy = fsatisfy;
    }
}