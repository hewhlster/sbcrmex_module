package org.fjh.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleChanceExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleChanceExample() {
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

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andLnameIsNull() {
            addCriterion("lname is null");
            return (Criteria) this;
        }

        public Criteria andLnameIsNotNull() {
            addCriterion("lname is not null");
            return (Criteria) this;
        }

        public Criteria andLnameEqualTo(String value) {
            addCriterion("lname =", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameNotEqualTo(String value) {
            addCriterion("lname <>", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameGreaterThan(String value) {
            addCriterion("lname >", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameGreaterThanOrEqualTo(String value) {
            addCriterion("lname >=", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameLessThan(String value) {
            addCriterion("lname <", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameLessThanOrEqualTo(String value) {
            addCriterion("lname <=", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameLike(String value) {
            addCriterion("lname like", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameNotLike(String value) {
            addCriterion("lname not like", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameIn(List<String> values) {
            addCriterion("lname in", values, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameNotIn(List<String> values) {
            addCriterion("lname not in", values, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameBetween(String value1, String value2) {
            addCriterion("lname between", value1, value2, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameNotBetween(String value1, String value2) {
            addCriterion("lname not between", value1, value2, "lname");
            return (Criteria) this;
        }

        public Criteria andLtel1IsNull() {
            addCriterion("ltel1 is null");
            return (Criteria) this;
        }

        public Criteria andLtel1IsNotNull() {
            addCriterion("ltel1 is not null");
            return (Criteria) this;
        }

        public Criteria andLtel1EqualTo(String value) {
            addCriterion("ltel1 =", value, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1NotEqualTo(String value) {
            addCriterion("ltel1 <>", value, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1GreaterThan(String value) {
            addCriterion("ltel1 >", value, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1GreaterThanOrEqualTo(String value) {
            addCriterion("ltel1 >=", value, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1LessThan(String value) {
            addCriterion("ltel1 <", value, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1LessThanOrEqualTo(String value) {
            addCriterion("ltel1 <=", value, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1Like(String value) {
            addCriterion("ltel1 like", value, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1NotLike(String value) {
            addCriterion("ltel1 not like", value, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1In(List<String> values) {
            addCriterion("ltel1 in", values, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1NotIn(List<String> values) {
            addCriterion("ltel1 not in", values, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1Between(String value1, String value2) {
            addCriterion("ltel1 between", value1, value2, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel1NotBetween(String value1, String value2) {
            addCriterion("ltel1 not between", value1, value2, "ltel1");
            return (Criteria) this;
        }

        public Criteria andLtel2IsNull() {
            addCriterion("ltel2 is null");
            return (Criteria) this;
        }

        public Criteria andLtel2IsNotNull() {
            addCriterion("ltel2 is not null");
            return (Criteria) this;
        }

        public Criteria andLtel2EqualTo(String value) {
            addCriterion("ltel2 =", value, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2NotEqualTo(String value) {
            addCriterion("ltel2 <>", value, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2GreaterThan(String value) {
            addCriterion("ltel2 >", value, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2GreaterThanOrEqualTo(String value) {
            addCriterion("ltel2 >=", value, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2LessThan(String value) {
            addCriterion("ltel2 <", value, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2LessThanOrEqualTo(String value) {
            addCriterion("ltel2 <=", value, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2Like(String value) {
            addCriterion("ltel2 like", value, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2NotLike(String value) {
            addCriterion("ltel2 not like", value, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2In(List<String> values) {
            addCriterion("ltel2 in", values, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2NotIn(List<String> values) {
            addCriterion("ltel2 not in", values, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2Between(String value1, String value2) {
            addCriterion("ltel2 between", value1, value2, "ltel2");
            return (Criteria) this;
        }

        public Criteria andLtel2NotBetween(String value1, String value2) {
            addCriterion("ltel2 not between", value1, value2, "ltel2");
            return (Criteria) this;
        }

        public Criteria andCaddrIsNull() {
            addCriterion("caddr is null");
            return (Criteria) this;
        }

        public Criteria andCaddrIsNotNull() {
            addCriterion("caddr is not null");
            return (Criteria) this;
        }

        public Criteria andCaddrEqualTo(String value) {
            addCriterion("caddr =", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrNotEqualTo(String value) {
            addCriterion("caddr <>", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrGreaterThan(String value) {
            addCriterion("caddr >", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrGreaterThanOrEqualTo(String value) {
            addCriterion("caddr >=", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrLessThan(String value) {
            addCriterion("caddr <", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrLessThanOrEqualTo(String value) {
            addCriterion("caddr <=", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrLike(String value) {
            addCriterion("caddr like", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrNotLike(String value) {
            addCriterion("caddr not like", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrIn(List<String> values) {
            addCriterion("caddr in", values, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrNotIn(List<String> values) {
            addCriterion("caddr not in", values, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrBetween(String value1, String value2) {
            addCriterion("caddr between", value1, value2, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrNotBetween(String value1, String value2) {
            addCriterion("caddr not between", value1, value2, "caddr");
            return (Criteria) this;
        }

        public Criteria andSummayIsNull() {
            addCriterion("summay is null");
            return (Criteria) this;
        }

        public Criteria andSummayIsNotNull() {
            addCriterion("summay is not null");
            return (Criteria) this;
        }

        public Criteria andSummayEqualTo(String value) {
            addCriterion("summay =", value, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayNotEqualTo(String value) {
            addCriterion("summay <>", value, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayGreaterThan(String value) {
            addCriterion("summay >", value, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayGreaterThanOrEqualTo(String value) {
            addCriterion("summay >=", value, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayLessThan(String value) {
            addCriterion("summay <", value, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayLessThanOrEqualTo(String value) {
            addCriterion("summay <=", value, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayLike(String value) {
            addCriterion("summay like", value, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayNotLike(String value) {
            addCriterion("summay not like", value, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayIn(List<String> values) {
            addCriterion("summay in", values, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayNotIn(List<String> values) {
            addCriterion("summay not in", values, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayBetween(String value1, String value2) {
            addCriterion("summay between", value1, value2, "summay");
            return (Criteria) this;
        }

        public Criteria andSummayNotBetween(String value1, String value2) {
            addCriterion("summay not between", value1, value2, "summay");
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