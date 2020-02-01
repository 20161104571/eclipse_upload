package com.imnu.SchoolBus.pojo;

import java.util.ArrayList;
import java.util.List;

public class DriverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DriverExample() {
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

        public Criteria andDIdIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andDIdIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andDIdEqualTo(Integer value) {
            addCriterion("d_id =", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThan(Integer value) {
            addCriterion("d_id >", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThan(Integer value) {
            addCriterion("d_id <", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdIn(List<Integer> values) {
            addCriterion("d_id in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDnameIsNull() {
            addCriterion("dname is null");
            return (Criteria) this;
        }

        public Criteria andDnameIsNotNull() {
            addCriterion("dname is not null");
            return (Criteria) this;
        }

        public Criteria andDnameEqualTo(String value) {
            addCriterion("dname =", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotEqualTo(String value) {
            addCriterion("dname <>", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameGreaterThan(String value) {
            addCriterion("dname >", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameGreaterThanOrEqualTo(String value) {
            addCriterion("dname >=", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLessThan(String value) {
            addCriterion("dname <", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLessThanOrEqualTo(String value) {
            addCriterion("dname <=", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLike(String value) {
            addCriterion("dname like", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotLike(String value) {
            addCriterion("dname not like", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameIn(List<String> values) {
            addCriterion("dname in", values, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotIn(List<String> values) {
            addCriterion("dname not in", values, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameBetween(String value1, String value2) {
            addCriterion("dname between", value1, value2, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotBetween(String value1, String value2) {
            addCriterion("dname not between", value1, value2, "dname");
            return (Criteria) this;
        }

        public Criteria andDnumberIsNull() {
            addCriterion("dnumber is null");
            return (Criteria) this;
        }

        public Criteria andDnumberIsNotNull() {
            addCriterion("dnumber is not null");
            return (Criteria) this;
        }

        public Criteria andDnumberEqualTo(String value) {
            addCriterion("dnumber =", value, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberNotEqualTo(String value) {
            addCriterion("dnumber <>", value, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberGreaterThan(String value) {
            addCriterion("dnumber >", value, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberGreaterThanOrEqualTo(String value) {
            addCriterion("dnumber >=", value, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberLessThan(String value) {
            addCriterion("dnumber <", value, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberLessThanOrEqualTo(String value) {
            addCriterion("dnumber <=", value, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberLike(String value) {
            addCriterion("dnumber like", value, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberNotLike(String value) {
            addCriterion("dnumber not like", value, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberIn(List<String> values) {
            addCriterion("dnumber in", values, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberNotIn(List<String> values) {
            addCriterion("dnumber not in", values, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberBetween(String value1, String value2) {
            addCriterion("dnumber between", value1, value2, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDnumberNotBetween(String value1, String value2) {
            addCriterion("dnumber not between", value1, value2, "dnumber");
            return (Criteria) this;
        }

        public Criteria andDphoneIsNull() {
            addCriterion("dphone is null");
            return (Criteria) this;
        }

        public Criteria andDphoneIsNotNull() {
            addCriterion("dphone is not null");
            return (Criteria) this;
        }

        public Criteria andDphoneEqualTo(String value) {
            addCriterion("dphone =", value, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneNotEqualTo(String value) {
            addCriterion("dphone <>", value, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneGreaterThan(String value) {
            addCriterion("dphone >", value, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneGreaterThanOrEqualTo(String value) {
            addCriterion("dphone >=", value, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneLessThan(String value) {
            addCriterion("dphone <", value, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneLessThanOrEqualTo(String value) {
            addCriterion("dphone <=", value, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneLike(String value) {
            addCriterion("dphone like", value, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneNotLike(String value) {
            addCriterion("dphone not like", value, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneIn(List<String> values) {
            addCriterion("dphone in", values, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneNotIn(List<String> values) {
            addCriterion("dphone not in", values, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneBetween(String value1, String value2) {
            addCriterion("dphone between", value1, value2, "dphone");
            return (Criteria) this;
        }

        public Criteria andDphoneNotBetween(String value1, String value2) {
            addCriterion("dphone not between", value1, value2, "dphone");
            return (Criteria) this;
        }

        public Criteria andDiverTimeIsNull() {
            addCriterion("diver_time is null");
            return (Criteria) this;
        }

        public Criteria andDiverTimeIsNotNull() {
            addCriterion("diver_time is not null");
            return (Criteria) this;
        }

        public Criteria andDiverTimeEqualTo(String value) {
            addCriterion("diver_time =", value, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeNotEqualTo(String value) {
            addCriterion("diver_time <>", value, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeGreaterThan(String value) {
            addCriterion("diver_time >", value, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeGreaterThanOrEqualTo(String value) {
            addCriterion("diver_time >=", value, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeLessThan(String value) {
            addCriterion("diver_time <", value, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeLessThanOrEqualTo(String value) {
            addCriterion("diver_time <=", value, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeLike(String value) {
            addCriterion("diver_time like", value, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeNotLike(String value) {
            addCriterion("diver_time not like", value, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeIn(List<String> values) {
            addCriterion("diver_time in", values, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeNotIn(List<String> values) {
            addCriterion("diver_time not in", values, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeBetween(String value1, String value2) {
            addCriterion("diver_time between", value1, value2, "diverTime");
            return (Criteria) this;
        }

        public Criteria andDiverTimeNotBetween(String value1, String value2) {
            addCriterion("diver_time not between", value1, value2, "diverTime");
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