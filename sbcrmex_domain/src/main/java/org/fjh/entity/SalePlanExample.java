package org.fjh.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalePlanExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalePlanExample() {
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

        public Criteria andAuidIsNull() {
            addCriterion("auid is null");
            return (Criteria) this;
        }

        public Criteria andAuidIsNotNull() {
            addCriterion("auid is not null");
            return (Criteria) this;
        }

        public Criteria andAuidEqualTo(String value) {
            addCriterion("auid =", value, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidNotEqualTo(String value) {
            addCriterion("auid <>", value, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidGreaterThan(String value) {
            addCriterion("auid >", value, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidGreaterThanOrEqualTo(String value) {
            addCriterion("auid >=", value, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidLessThan(String value) {
            addCriterion("auid <", value, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidLessThanOrEqualTo(String value) {
            addCriterion("auid <=", value, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidLike(String value) {
            addCriterion("auid like", value, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidNotLike(String value) {
            addCriterion("auid not like", value, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidIn(List<String> values) {
            addCriterion("auid in", values, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidNotIn(List<String> values) {
            addCriterion("auid not in", values, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidBetween(String value1, String value2) {
            addCriterion("auid between", value1, value2, "auid");
            return (Criteria) this;
        }

        public Criteria andAuidNotBetween(String value1, String value2) {
            addCriterion("auid not between", value1, value2, "auid");
            return (Criteria) this;
        }

        public Criteria andAcreatedateIsNull() {
            addCriterion("acreatedate is null");
            return (Criteria) this;
        }

        public Criteria andAcreatedateIsNotNull() {
            addCriterion("acreatedate is not null");
            return (Criteria) this;
        }

        public Criteria andAcreatedateEqualTo(Date value) {
            addCriterion("acreatedate =", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateNotEqualTo(Date value) {
            addCriterion("acreatedate <>", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateGreaterThan(Date value) {
            addCriterion("acreatedate >", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("acreatedate >=", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateLessThan(Date value) {
            addCriterion("acreatedate <", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateLessThanOrEqualTo(Date value) {
            addCriterion("acreatedate <=", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateIn(List<Date> values) {
            addCriterion("acreatedate in", values, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateNotIn(List<Date> values) {
            addCriterion("acreatedate not in", values, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateBetween(Date value1, Date value2) {
            addCriterion("acreatedate between", value1, value2, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateNotBetween(Date value1, Date value2) {
            addCriterion("acreatedate not between", value1, value2, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andDuidIsNull() {
            addCriterion("duid is null");
            return (Criteria) this;
        }

        public Criteria andDuidIsNotNull() {
            addCriterion("duid is not null");
            return (Criteria) this;
        }

        public Criteria andDuidEqualTo(String value) {
            addCriterion("duid =", value, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidNotEqualTo(String value) {
            addCriterion("duid <>", value, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidGreaterThan(String value) {
            addCriterion("duid >", value, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidGreaterThanOrEqualTo(String value) {
            addCriterion("duid >=", value, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidLessThan(String value) {
            addCriterion("duid <", value, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidLessThanOrEqualTo(String value) {
            addCriterion("duid <=", value, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidLike(String value) {
            addCriterion("duid like", value, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidNotLike(String value) {
            addCriterion("duid not like", value, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidIn(List<String> values) {
            addCriterion("duid in", values, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidNotIn(List<String> values) {
            addCriterion("duid not in", values, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidBetween(String value1, String value2) {
            addCriterion("duid between", value1, value2, "duid");
            return (Criteria) this;
        }

        public Criteria andDuidNotBetween(String value1, String value2) {
            addCriterion("duid not between", value1, value2, "duid");
            return (Criteria) this;
        }

        public Criteria andDcreatedateIsNull() {
            addCriterion("dcreatedate is null");
            return (Criteria) this;
        }

        public Criteria andDcreatedateIsNotNull() {
            addCriterion("dcreatedate is not null");
            return (Criteria) this;
        }

        public Criteria andDcreatedateEqualTo(String value) {
            addCriterion("dcreatedate =", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotEqualTo(String value) {
            addCriterion("dcreatedate <>", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateGreaterThan(String value) {
            addCriterion("dcreatedate >", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("dcreatedate >=", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateLessThan(String value) {
            addCriterion("dcreatedate <", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateLessThanOrEqualTo(String value) {
            addCriterion("dcreatedate <=", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateLike(String value) {
            addCriterion("dcreatedate like", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotLike(String value) {
            addCriterion("dcreatedate not like", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateIn(List<String> values) {
            addCriterion("dcreatedate in", values, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotIn(List<String> values) {
            addCriterion("dcreatedate not in", values, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateBetween(String value1, String value2) {
            addCriterion("dcreatedate between", value1, value2, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotBetween(String value1, String value2) {
            addCriterion("dcreatedate not between", value1, value2, "dcreatedate");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
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