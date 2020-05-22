package org.fjh.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceItemsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceItemsExample() {
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

        public Criteria andUpdatedateIsNull() {
            addCriterion("updatedate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updatedate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(Date value) {
            addCriterion("updatedate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(Date value) {
            addCriterion("updatedate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(Date value) {
            addCriterion("updatedate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("updatedate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(Date value) {
            addCriterion("updatedate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(Date value) {
            addCriterion("updatedate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<Date> values) {
            addCriterion("updatedate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<Date> values) {
            addCriterion("updatedate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(Date value1, Date value2) {
            addCriterion("updatedate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(Date value1, Date value2) {
            addCriterion("updatedate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
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

        public Criteria andAmemoIsNull() {
            addCriterion("amemo is null");
            return (Criteria) this;
        }

        public Criteria andAmemoIsNotNull() {
            addCriterion("amemo is not null");
            return (Criteria) this;
        }

        public Criteria andAmemoEqualTo(String value) {
            addCriterion("amemo =", value, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoNotEqualTo(String value) {
            addCriterion("amemo <>", value, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoGreaterThan(String value) {
            addCriterion("amemo >", value, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoGreaterThanOrEqualTo(String value) {
            addCriterion("amemo >=", value, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoLessThan(String value) {
            addCriterion("amemo <", value, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoLessThanOrEqualTo(String value) {
            addCriterion("amemo <=", value, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoLike(String value) {
            addCriterion("amemo like", value, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoNotLike(String value) {
            addCriterion("amemo not like", value, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoIn(List<String> values) {
            addCriterion("amemo in", values, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoNotIn(List<String> values) {
            addCriterion("amemo not in", values, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoBetween(String value1, String value2) {
            addCriterion("amemo between", value1, value2, "amemo");
            return (Criteria) this;
        }

        public Criteria andAmemoNotBetween(String value1, String value2) {
            addCriterion("amemo not between", value1, value2, "amemo");
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

        public Criteria andDcreatedateEqualTo(Date value) {
            addCriterion("dcreatedate =", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotEqualTo(Date value) {
            addCriterion("dcreatedate <>", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateGreaterThan(Date value) {
            addCriterion("dcreatedate >", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("dcreatedate >=", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateLessThan(Date value) {
            addCriterion("dcreatedate <", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateLessThanOrEqualTo(Date value) {
            addCriterion("dcreatedate <=", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateIn(List<Date> values) {
            addCriterion("dcreatedate in", values, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotIn(List<Date> values) {
            addCriterion("dcreatedate not in", values, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateBetween(Date value1, Date value2) {
            addCriterion("dcreatedate between", value1, value2, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotBetween(Date value1, Date value2) {
            addCriterion("dcreatedate not between", value1, value2, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDresultIsNull() {
            addCriterion("dresult is null");
            return (Criteria) this;
        }

        public Criteria andDresultIsNotNull() {
            addCriterion("dresult is not null");
            return (Criteria) this;
        }

        public Criteria andDresultEqualTo(String value) {
            addCriterion("dresult =", value, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultNotEqualTo(String value) {
            addCriterion("dresult <>", value, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultGreaterThan(String value) {
            addCriterion("dresult >", value, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultGreaterThanOrEqualTo(String value) {
            addCriterion("dresult >=", value, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultLessThan(String value) {
            addCriterion("dresult <", value, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultLessThanOrEqualTo(String value) {
            addCriterion("dresult <=", value, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultLike(String value) {
            addCriterion("dresult like", value, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultNotLike(String value) {
            addCriterion("dresult not like", value, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultIn(List<String> values) {
            addCriterion("dresult in", values, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultNotIn(List<String> values) {
            addCriterion("dresult not in", values, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultBetween(String value1, String value2) {
            addCriterion("dresult between", value1, value2, "dresult");
            return (Criteria) this;
        }

        public Criteria andDresultNotBetween(String value1, String value2) {
            addCriterion("dresult not between", value1, value2, "dresult");
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