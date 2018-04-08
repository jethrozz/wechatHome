package com.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TeacherExample() {
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

        public Criteria andT_idIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andT_idIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andT_idEqualTo(Integer value) {
            addCriterion("t_id =", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idNotEqualTo(Integer value) {
            addCriterion("t_id <>", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idGreaterThan(Integer value) {
            addCriterion("t_id >", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_id >=", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idLessThan(Integer value) {
            addCriterion("t_id <", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idLessThanOrEqualTo(Integer value) {
            addCriterion("t_id <=", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idIn(List<Integer> values) {
            addCriterion("t_id in", values, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idNotIn(List<Integer> values) {
            addCriterion("t_id not in", values, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idBetween(Integer value1, Integer value2) {
            addCriterion("t_id between", value1, value2, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idNotBetween(Integer value1, Integer value2) {
            addCriterion("t_id not between", value1, value2, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_nameIsNull() {
            addCriterion("t_name is null");
            return (Criteria) this;
        }

        public Criteria andT_nameIsNotNull() {
            addCriterion("t_name is not null");
            return (Criteria) this;
        }

        public Criteria andT_nameEqualTo(String value) {
            addCriterion("t_name =", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameNotEqualTo(String value) {
            addCriterion("t_name <>", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameGreaterThan(String value) {
            addCriterion("t_name >", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameGreaterThanOrEqualTo(String value) {
            addCriterion("t_name >=", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameLessThan(String value) {
            addCriterion("t_name <", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameLessThanOrEqualTo(String value) {
            addCriterion("t_name <=", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameLike(String value) {
            addCriterion("t_name like", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameNotLike(String value) {
            addCriterion("t_name not like", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameIn(List<String> values) {
            addCriterion("t_name in", values, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameNotIn(List<String> values) {
            addCriterion("t_name not in", values, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameBetween(String value1, String value2) {
            addCriterion("t_name between", value1, value2, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameNotBetween(String value1, String value2) {
            addCriterion("t_name not between", value1, value2, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_subjectIsNull() {
            addCriterion("t_subject is null");
            return (Criteria) this;
        }

        public Criteria andT_subjectIsNotNull() {
            addCriterion("t_subject is not null");
            return (Criteria) this;
        }

        public Criteria andT_subjectEqualTo(Integer value) {
            addCriterion("t_subject =", value, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectNotEqualTo(Integer value) {
            addCriterion("t_subject <>", value, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectGreaterThan(Integer value) {
            addCriterion("t_subject >", value, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_subject >=", value, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectLessThan(Integer value) {
            addCriterion("t_subject <", value, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectLessThanOrEqualTo(Integer value) {
            addCriterion("t_subject <=", value, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectIn(List<Integer> values) {
            addCriterion("t_subject in", values, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectNotIn(List<Integer> values) {
            addCriterion("t_subject not in", values, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectBetween(Integer value1, Integer value2) {
            addCriterion("t_subject between", value1, value2, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_subjectNotBetween(Integer value1, Integer value2) {
            addCriterion("t_subject not between", value1, value2, "t_subject");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberIsNull() {
            addCriterion("t_phone_number is null");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberIsNotNull() {
            addCriterion("t_phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberEqualTo(String value) {
            addCriterion("t_phone_number =", value, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberNotEqualTo(String value) {
            addCriterion("t_phone_number <>", value, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberGreaterThan(String value) {
            addCriterion("t_phone_number >", value, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberGreaterThanOrEqualTo(String value) {
            addCriterion("t_phone_number >=", value, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberLessThan(String value) {
            addCriterion("t_phone_number <", value, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberLessThanOrEqualTo(String value) {
            addCriterion("t_phone_number <=", value, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberLike(String value) {
            addCriterion("t_phone_number like", value, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberNotLike(String value) {
            addCriterion("t_phone_number not like", value, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberIn(List<String> values) {
            addCriterion("t_phone_number in", values, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberNotIn(List<String> values) {
            addCriterion("t_phone_number not in", values, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberBetween(String value1, String value2) {
            addCriterion("t_phone_number between", value1, value2, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberNotBetween(String value1, String value2) {
            addCriterion("t_phone_number not between", value1, value2, "t_phone_number");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterIsNull() {
            addCriterion("t_is_headmaster is null");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterIsNotNull() {
            addCriterion("t_is_headmaster is not null");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterEqualTo(Integer value) {
            addCriterion("t_is_headmaster =", value, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterNotEqualTo(Integer value) {
            addCriterion("t_is_headmaster <>", value, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterGreaterThan(Integer value) {
            addCriterion("t_is_headmaster >", value, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_is_headmaster >=", value, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterLessThan(Integer value) {
            addCriterion("t_is_headmaster <", value, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterLessThanOrEqualTo(Integer value) {
            addCriterion("t_is_headmaster <=", value, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterIn(List<Integer> values) {
            addCriterion("t_is_headmaster in", values, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterNotIn(List<Integer> values) {
            addCriterion("t_is_headmaster not in", values, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterBetween(Integer value1, Integer value2) {
            addCriterion("t_is_headmaster between", value1, value2, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_is_headmasterNotBetween(Integer value1, Integer value2) {
            addCriterion("t_is_headmaster not between", value1, value2, "t_is_headmaster");
            return (Criteria) this;
        }

        public Criteria andT_create_timeIsNull() {
            addCriterion("t_create_time is null");
            return (Criteria) this;
        }

        public Criteria andT_create_timeIsNotNull() {
            addCriterion("t_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andT_create_timeEqualTo(Date value) {
            addCriterion("t_create_time =", value, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeNotEqualTo(Date value) {
            addCriterion("t_create_time <>", value, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeGreaterThan(Date value) {
            addCriterion("t_create_time >", value, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("t_create_time >=", value, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeLessThan(Date value) {
            addCriterion("t_create_time <", value, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("t_create_time <=", value, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeIn(List<Date> values) {
            addCriterion("t_create_time in", values, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeNotIn(List<Date> values) {
            addCriterion("t_create_time not in", values, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeBetween(Date value1, Date value2) {
            addCriterion("t_create_time between", value1, value2, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("t_create_time not between", value1, value2, "t_create_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeIsNull() {
            addCriterion("t_update_time is null");
            return (Criteria) this;
        }

        public Criteria andT_update_timeIsNotNull() {
            addCriterion("t_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andT_update_timeEqualTo(Date value) {
            addCriterion("t_update_time =", value, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeNotEqualTo(Date value) {
            addCriterion("t_update_time <>", value, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeGreaterThan(Date value) {
            addCriterion("t_update_time >", value, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("t_update_time >=", value, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeLessThan(Date value) {
            addCriterion("t_update_time <", value, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("t_update_time <=", value, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeIn(List<Date> values) {
            addCriterion("t_update_time in", values, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeNotIn(List<Date> values) {
            addCriterion("t_update_time not in", values, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeBetween(Date value1, Date value2) {
            addCriterion("t_update_time between", value1, value2, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("t_update_time not between", value1, value2, "t_update_time");
            return (Criteria) this;
        }

        public Criteria andT_nameLikeInsensitive(String value) {
            addCriterion("upper(t_name) like", value.toUpperCase(), "t_name");
            return (Criteria) this;
        }

        public Criteria andT_phone_numberLikeInsensitive(String value) {
            addCriterion("upper(t_phone_number) like", value.toUpperCase(), "t_phone_number");
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