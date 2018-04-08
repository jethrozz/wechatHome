package com.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ParentExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setPageInfo(Integer currentPage, Integer pageSize) {
        if(pageSize<1) throw new IllegalArgumentException("页大小不能小于1！");
        this.limit=pageSize;
        if(currentPage<1) throw new IllegalArgumentException("页数不能小于1！");
        this.offset=(currentPage-1)*pageSize;
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

        public Criteria andP_idIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andP_idIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andP_idEqualTo(Integer value) {
            addCriterion("p_id =", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idGreaterThan(Integer value) {
            addCriterion("p_id >", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idLessThan(Integer value) {
            addCriterion("p_id <", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idIn(List<Integer> values) {
            addCriterion("p_id in", values, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_nameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andP_nameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andP_nameEqualTo(String value) {
            addCriterion("p_name =", value, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameGreaterThan(String value) {
            addCriterion("p_name >", value, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameLessThan(String value) {
            addCriterion("p_name <", value, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameLike(String value) {
            addCriterion("p_name like", value, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameNotLike(String value) {
            addCriterion("p_name not like", value, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameIn(List<String> values) {
            addCriterion("p_name in", values, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_nameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "p_name");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberIsNull() {
            addCriterion("p_phone_number is null");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberIsNotNull() {
            addCriterion("p_phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberEqualTo(String value) {
            addCriterion("p_phone_number =", value, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberNotEqualTo(String value) {
            addCriterion("p_phone_number <>", value, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberGreaterThan(String value) {
            addCriterion("p_phone_number >", value, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberGreaterThanOrEqualTo(String value) {
            addCriterion("p_phone_number >=", value, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberLessThan(String value) {
            addCriterion("p_phone_number <", value, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberLessThanOrEqualTo(String value) {
            addCriterion("p_phone_number <=", value, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberLike(String value) {
            addCriterion("p_phone_number like", value, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberNotLike(String value) {
            addCriterion("p_phone_number not like", value, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberIn(List<String> values) {
            addCriterion("p_phone_number in", values, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberNotIn(List<String> values) {
            addCriterion("p_phone_number not in", values, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberBetween(String value1, String value2) {
            addCriterion("p_phone_number between", value1, value2, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberNotBetween(String value1, String value2) {
            addCriterion("p_phone_number not between", value1, value2, "p_phone_number");
            return (Criteria) this;
        }

        public Criteria andP_create_timeIsNull() {
            addCriterion("p_create_time is null");
            return (Criteria) this;
        }

        public Criteria andP_create_timeIsNotNull() {
            addCriterion("p_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andP_create_timeEqualTo(Date value) {
            addCriterion("p_create_time =", value, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeNotEqualTo(Date value) {
            addCriterion("p_create_time <>", value, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeGreaterThan(Date value) {
            addCriterion("p_create_time >", value, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_create_time >=", value, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeLessThan(Date value) {
            addCriterion("p_create_time <", value, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("p_create_time <=", value, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeIn(List<Date> values) {
            addCriterion("p_create_time in", values, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeNotIn(List<Date> values) {
            addCriterion("p_create_time not in", values, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeBetween(Date value1, Date value2) {
            addCriterion("p_create_time between", value1, value2, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("p_create_time not between", value1, value2, "p_create_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeIsNull() {
            addCriterion("p_update_time is null");
            return (Criteria) this;
        }

        public Criteria andP_update_timeIsNotNull() {
            addCriterion("p_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andP_update_timeEqualTo(Date value) {
            addCriterion("p_update_time =", value, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeNotEqualTo(Date value) {
            addCriterion("p_update_time <>", value, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeGreaterThan(Date value) {
            addCriterion("p_update_time >", value, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_update_time >=", value, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeLessThan(Date value) {
            addCriterion("p_update_time <", value, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("p_update_time <=", value, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeIn(List<Date> values) {
            addCriterion("p_update_time in", values, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeNotIn(List<Date> values) {
            addCriterion("p_update_time not in", values, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeBetween(Date value1, Date value2) {
            addCriterion("p_update_time between", value1, value2, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("p_update_time not between", value1, value2, "p_update_time");
            return (Criteria) this;
        }

        public Criteria andP_nameLikeInsensitive(String value) {
            addCriterion("upper(p_name) like", value.toUpperCase(), "p_name");
            return (Criteria) this;
        }

        public Criteria andP_phone_numberLikeInsensitive(String value) {
            addCriterion("upper(p_phone_number) like", value.toUpperCase(), "p_phone_number");
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