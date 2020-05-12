package org.fjh.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNull() {
            addCriterion("modifydate is null");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNotNull() {
            addCriterion("modifydate is not null");
            return (Criteria) this;
        }

        public Criteria andModifydateEqualTo(Date value) {
            addCriterion("modifydate =", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotEqualTo(Date value) {
            addCriterion("modifydate <>", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThan(Date value) {
            addCriterion("modifydate >", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThanOrEqualTo(Date value) {
            addCriterion("modifydate >=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThan(Date value) {
            addCriterion("modifydate <", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThanOrEqualTo(Date value) {
            addCriterion("modifydate <=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateIn(List<Date> values) {
            addCriterion("modifydate in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotIn(List<Date> values) {
            addCriterion("modifydate not in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateBetween(Date value1, Date value2) {
            addCriterion("modifydate between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotBetween(Date value1, Date value2) {
            addCriterion("modifydate not between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andStidIsNull() {
            addCriterion("stid is null");
            return (Criteria) this;
        }

        public Criteria andStidIsNotNull() {
            addCriterion("stid is not null");
            return (Criteria) this;
        }

        public Criteria andStidEqualTo(String value) {
            addCriterion("stid =", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotEqualTo(String value) {
            addCriterion("stid <>", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThan(String value) {
            addCriterion("stid >", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThanOrEqualTo(String value) {
            addCriterion("stid >=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThan(String value) {
            addCriterion("stid <", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThanOrEqualTo(String value) {
            addCriterion("stid <=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLike(String value) {
            addCriterion("stid like", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotLike(String value) {
            addCriterion("stid not like", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidIn(List<String> values) {
            addCriterion("stid in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotIn(List<String> values) {
            addCriterion("stid not in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidBetween(String value1, String value2) {
            addCriterion("stid between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotBetween(String value1, String value2) {
            addCriterion("stid not between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andCuidIsNull() {
            addCriterion("cuid is null");
            return (Criteria) this;
        }

        public Criteria andCuidIsNotNull() {
            addCriterion("cuid is not null");
            return (Criteria) this;
        }

        public Criteria andCuidEqualTo(String value) {
            addCriterion("cuid =", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotEqualTo(String value) {
            addCriterion("cuid <>", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidGreaterThan(String value) {
            addCriterion("cuid >", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidGreaterThanOrEqualTo(String value) {
            addCriterion("cuid >=", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidLessThan(String value) {
            addCriterion("cuid <", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidLessThanOrEqualTo(String value) {
            addCriterion("cuid <=", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidLike(String value) {
            addCriterion("cuid like", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotLike(String value) {
            addCriterion("cuid not like", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidIn(List<String> values) {
            addCriterion("cuid in", values, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotIn(List<String> values) {
            addCriterion("cuid not in", values, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidBetween(String value1, String value2) {
            addCriterion("cuid between", value1, value2, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotBetween(String value1, String value2) {
            addCriterion("cuid not between", value1, value2, "cuid");
            return (Criteria) this;
        }

        public Criteria andFauidIsNull() {
            addCriterion("fauid is null");
            return (Criteria) this;
        }

        public Criteria andFauidIsNotNull() {
            addCriterion("fauid is not null");
            return (Criteria) this;
        }

        public Criteria andFauidEqualTo(String value) {
            addCriterion("fauid =", value, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidNotEqualTo(String value) {
            addCriterion("fauid <>", value, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidGreaterThan(String value) {
            addCriterion("fauid >", value, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidGreaterThanOrEqualTo(String value) {
            addCriterion("fauid >=", value, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidLessThan(String value) {
            addCriterion("fauid <", value, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidLessThanOrEqualTo(String value) {
            addCriterion("fauid <=", value, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidLike(String value) {
            addCriterion("fauid like", value, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidNotLike(String value) {
            addCriterion("fauid not like", value, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidIn(List<String> values) {
            addCriterion("fauid in", values, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidNotIn(List<String> values) {
            addCriterion("fauid not in", values, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidBetween(String value1, String value2) {
            addCriterion("fauid between", value1, value2, "fauid");
            return (Criteria) this;
        }

        public Criteria andFauidNotBetween(String value1, String value2) {
            addCriterion("fauid not between", value1, value2, "fauid");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeIsNull() {
            addCriterion("facreatetime is null");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeIsNotNull() {
            addCriterion("facreatetime is not null");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeEqualTo(Date value) {
            addCriterion("facreatetime =", value, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeNotEqualTo(Date value) {
            addCriterion("facreatetime <>", value, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeGreaterThan(Date value) {
            addCriterion("facreatetime >", value, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("facreatetime >=", value, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeLessThan(Date value) {
            addCriterion("facreatetime <", value, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("facreatetime <=", value, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeIn(List<Date> values) {
            addCriterion("facreatetime in", values, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeNotIn(List<Date> values) {
            addCriterion("facreatetime not in", values, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeBetween(Date value1, Date value2) {
            addCriterion("facreatetime between", value1, value2, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFacreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("facreatetime not between", value1, value2, "facreatetime");
            return (Criteria) this;
        }

        public Criteria andFduidIsNull() {
            addCriterion("fduid is null");
            return (Criteria) this;
        }

        public Criteria andFduidIsNotNull() {
            addCriterion("fduid is not null");
            return (Criteria) this;
        }

        public Criteria andFduidEqualTo(String value) {
            addCriterion("fduid =", value, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidNotEqualTo(String value) {
            addCriterion("fduid <>", value, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidGreaterThan(String value) {
            addCriterion("fduid >", value, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidGreaterThanOrEqualTo(String value) {
            addCriterion("fduid >=", value, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidLessThan(String value) {
            addCriterion("fduid <", value, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidLessThanOrEqualTo(String value) {
            addCriterion("fduid <=", value, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidLike(String value) {
            addCriterion("fduid like", value, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidNotLike(String value) {
            addCriterion("fduid not like", value, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidIn(List<String> values) {
            addCriterion("fduid in", values, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidNotIn(List<String> values) {
            addCriterion("fduid not in", values, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidBetween(String value1, String value2) {
            addCriterion("fduid between", value1, value2, "fduid");
            return (Criteria) this;
        }

        public Criteria andFduidNotBetween(String value1, String value2) {
            addCriterion("fduid not between", value1, value2, "fduid");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeIsNull() {
            addCriterion("fdcreatetime is null");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeIsNotNull() {
            addCriterion("fdcreatetime is not null");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeEqualTo(Date value) {
            addCriterion("fdcreatetime =", value, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeNotEqualTo(Date value) {
            addCriterion("fdcreatetime <>", value, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeGreaterThan(Date value) {
            addCriterion("fdcreatetime >", value, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fdcreatetime >=", value, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeLessThan(Date value) {
            addCriterion("fdcreatetime <", value, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("fdcreatetime <=", value, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeIn(List<Date> values) {
            addCriterion("fdcreatetime in", values, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeNotIn(List<Date> values) {
            addCriterion("fdcreatetime not in", values, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeBetween(Date value1, Date value2) {
            addCriterion("fdcreatetime between", value1, value2, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFdcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("fdcreatetime not between", value1, value2, "fdcreatetime");
            return (Criteria) this;
        }

        public Criteria andFresultIsNull() {
            addCriterion("fresult is null");
            return (Criteria) this;
        }

        public Criteria andFresultIsNotNull() {
            addCriterion("fresult is not null");
            return (Criteria) this;
        }

        public Criteria andFresultEqualTo(String value) {
            addCriterion("fresult =", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultNotEqualTo(String value) {
            addCriterion("fresult <>", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultGreaterThan(String value) {
            addCriterion("fresult >", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultGreaterThanOrEqualTo(String value) {
            addCriterion("fresult >=", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultLessThan(String value) {
            addCriterion("fresult <", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultLessThanOrEqualTo(String value) {
            addCriterion("fresult <=", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultLike(String value) {
            addCriterion("fresult like", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultNotLike(String value) {
            addCriterion("fresult not like", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultIn(List<String> values) {
            addCriterion("fresult in", values, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultNotIn(List<String> values) {
            addCriterion("fresult not in", values, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultBetween(String value1, String value2) {
            addCriterion("fresult between", value1, value2, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultNotBetween(String value1, String value2) {
            addCriterion("fresult not between", value1, value2, "fresult");
            return (Criteria) this;
        }

        public Criteria andFsatisfyIsNull() {
            addCriterion("fsatisfy is null");
            return (Criteria) this;
        }

        public Criteria andFsatisfyIsNotNull() {
            addCriterion("fsatisfy is not null");
            return (Criteria) this;
        }

        public Criteria andFsatisfyEqualTo(Integer value) {
            addCriterion("fsatisfy =", value, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyNotEqualTo(Integer value) {
            addCriterion("fsatisfy <>", value, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyGreaterThan(Integer value) {
            addCriterion("fsatisfy >", value, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsatisfy >=", value, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyLessThan(Integer value) {
            addCriterion("fsatisfy <", value, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyLessThanOrEqualTo(Integer value) {
            addCriterion("fsatisfy <=", value, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyIn(List<Integer> values) {
            addCriterion("fsatisfy in", values, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyNotIn(List<Integer> values) {
            addCriterion("fsatisfy not in", values, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyBetween(Integer value1, Integer value2) {
            addCriterion("fsatisfy between", value1, value2, "fsatisfy");
            return (Criteria) this;
        }

        public Criteria andFsatisfyNotBetween(Integer value1, Integer value2) {
            addCriterion("fsatisfy not between", value1, value2, "fsatisfy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}