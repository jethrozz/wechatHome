package com.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ChatRecordExample() {
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

        public Criteria andCr_idIsNull() {
            addCriterion("cr_id is null");
            return (Criteria) this;
        }

        public Criteria andCr_idIsNotNull() {
            addCriterion("cr_id is not null");
            return (Criteria) this;
        }

        public Criteria andCr_idEqualTo(Integer value) {
            addCriterion("cr_id =", value, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idNotEqualTo(Integer value) {
            addCriterion("cr_id <>", value, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idGreaterThan(Integer value) {
            addCriterion("cr_id >", value, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("cr_id >=", value, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idLessThan(Integer value) {
            addCriterion("cr_id <", value, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idLessThanOrEqualTo(Integer value) {
            addCriterion("cr_id <=", value, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idIn(List<Integer> values) {
            addCriterion("cr_id in", values, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idNotIn(List<Integer> values) {
            addCriterion("cr_id not in", values, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idBetween(Integer value1, Integer value2) {
            addCriterion("cr_id between", value1, value2, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_idNotBetween(Integer value1, Integer value2) {
            addCriterion("cr_id not between", value1, value2, "cr_id");
            return (Criteria) this;
        }

        public Criteria andCr_from_userIsNull() {
            addCriterion("cr_from_user is null");
            return (Criteria) this;
        }

        public Criteria andCr_from_userIsNotNull() {
            addCriterion("cr_from_user is not null");
            return (Criteria) this;
        }

        public Criteria andCr_from_userEqualTo(Integer value) {
            addCriterion("cr_from_user =", value, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userNotEqualTo(Integer value) {
            addCriterion("cr_from_user <>", value, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userGreaterThan(Integer value) {
            addCriterion("cr_from_user >", value, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userGreaterThanOrEqualTo(Integer value) {
            addCriterion("cr_from_user >=", value, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userLessThan(Integer value) {
            addCriterion("cr_from_user <", value, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userLessThanOrEqualTo(Integer value) {
            addCriterion("cr_from_user <=", value, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userIn(List<Integer> values) {
            addCriterion("cr_from_user in", values, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userNotIn(List<Integer> values) {
            addCriterion("cr_from_user not in", values, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userBetween(Integer value1, Integer value2) {
            addCriterion("cr_from_user between", value1, value2, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_from_userNotBetween(Integer value1, Integer value2) {
            addCriterion("cr_from_user not between", value1, value2, "cr_from_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userIsNull() {
            addCriterion("cr_to_user is null");
            return (Criteria) this;
        }

        public Criteria andCr_to_userIsNotNull() {
            addCriterion("cr_to_user is not null");
            return (Criteria) this;
        }

        public Criteria andCr_to_userEqualTo(Integer value) {
            addCriterion("cr_to_user =", value, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userNotEqualTo(Integer value) {
            addCriterion("cr_to_user <>", value, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userGreaterThan(Integer value) {
            addCriterion("cr_to_user >", value, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userGreaterThanOrEqualTo(Integer value) {
            addCriterion("cr_to_user >=", value, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userLessThan(Integer value) {
            addCriterion("cr_to_user <", value, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userLessThanOrEqualTo(Integer value) {
            addCriterion("cr_to_user <=", value, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userIn(List<Integer> values) {
            addCriterion("cr_to_user in", values, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userNotIn(List<Integer> values) {
            addCriterion("cr_to_user not in", values, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userBetween(Integer value1, Integer value2) {
            addCriterion("cr_to_user between", value1, value2, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_to_userNotBetween(Integer value1, Integer value2) {
            addCriterion("cr_to_user not between", value1, value2, "cr_to_user");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeIsNull() {
            addCriterion("cr_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeIsNotNull() {
            addCriterion("cr_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeEqualTo(Date value) {
            addCriterion("cr_create_time =", value, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeNotEqualTo(Date value) {
            addCriterion("cr_create_time <>", value, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeGreaterThan(Date value) {
            addCriterion("cr_create_time >", value, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("cr_create_time >=", value, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeLessThan(Date value) {
            addCriterion("cr_create_time <", value, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("cr_create_time <=", value, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeIn(List<Date> values) {
            addCriterion("cr_create_time in", values, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeNotIn(List<Date> values) {
            addCriterion("cr_create_time not in", values, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeBetween(Date value1, Date value2) {
            addCriterion("cr_create_time between", value1, value2, "cr_create_time");
            return (Criteria) this;
        }

        public Criteria andCr_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("cr_create_time not between", value1, value2, "cr_create_time");
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