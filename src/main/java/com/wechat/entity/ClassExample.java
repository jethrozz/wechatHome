package com.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ClassExample() {
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

        public Criteria andC_idIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andC_idIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andC_idEqualTo(Integer value) {
            addCriterion("c_id =", value, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idGreaterThan(Integer value) {
            addCriterion("c_id >", value, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idLessThan(Integer value) {
            addCriterion("c_id <", value, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idIn(List<Integer> values) {
            addCriterion("c_id in", values, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_idNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "c_id");
            return (Criteria) this;
        }

        public Criteria andC_greadIsNull() {
            addCriterion("c_gread is null");
            return (Criteria) this;
        }

        public Criteria andC_greadIsNotNull() {
            addCriterion("c_gread is not null");
            return (Criteria) this;
        }

        public Criteria andC_greadEqualTo(Integer value) {
            addCriterion("c_gread =", value, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadNotEqualTo(Integer value) {
            addCriterion("c_gread <>", value, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadGreaterThan(Integer value) {
            addCriterion("c_gread >", value, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_gread >=", value, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadLessThan(Integer value) {
            addCriterion("c_gread <", value, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadLessThanOrEqualTo(Integer value) {
            addCriterion("c_gread <=", value, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadIn(List<Integer> values) {
            addCriterion("c_gread in", values, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadNotIn(List<Integer> values) {
            addCriterion("c_gread not in", values, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadBetween(Integer value1, Integer value2) {
            addCriterion("c_gread between", value1, value2, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_greadNotBetween(Integer value1, Integer value2) {
            addCriterion("c_gread not between", value1, value2, "c_gread");
            return (Criteria) this;
        }

        public Criteria andC_classIsNull() {
            addCriterion("c_class is null");
            return (Criteria) this;
        }

        public Criteria andC_classIsNotNull() {
            addCriterion("c_class is not null");
            return (Criteria) this;
        }

        public Criteria andC_classEqualTo(Integer value) {
            addCriterion("c_class =", value, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classNotEqualTo(Integer value) {
            addCriterion("c_class <>", value, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classGreaterThan(Integer value) {
            addCriterion("c_class >", value, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_class >=", value, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classLessThan(Integer value) {
            addCriterion("c_class <", value, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classLessThanOrEqualTo(Integer value) {
            addCriterion("c_class <=", value, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classIn(List<Integer> values) {
            addCriterion("c_class in", values, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classNotIn(List<Integer> values) {
            addCriterion("c_class not in", values, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classBetween(Integer value1, Integer value2) {
            addCriterion("c_class between", value1, value2, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_classNotBetween(Integer value1, Integer value2) {
            addCriterion("c_class not between", value1, value2, "c_class");
            return (Criteria) this;
        }

        public Criteria andC_create_timeIsNull() {
            addCriterion("c_create_time is null");
            return (Criteria) this;
        }

        public Criteria andC_create_timeIsNotNull() {
            addCriterion("c_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andC_create_timeEqualTo(Date value) {
            addCriterion("c_create_time =", value, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeNotEqualTo(Date value) {
            addCriterion("c_create_time <>", value, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeGreaterThan(Date value) {
            addCriterion("c_create_time >", value, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_create_time >=", value, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeLessThan(Date value) {
            addCriterion("c_create_time <", value, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("c_create_time <=", value, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeIn(List<Date> values) {
            addCriterion("c_create_time in", values, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeNotIn(List<Date> values) {
            addCriterion("c_create_time not in", values, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeBetween(Date value1, Date value2) {
            addCriterion("c_create_time between", value1, value2, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("c_create_time not between", value1, value2, "c_create_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeIsNull() {
            addCriterion("c_update_time is null");
            return (Criteria) this;
        }

        public Criteria andC_update_timeIsNotNull() {
            addCriterion("c_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andC_update_timeEqualTo(Date value) {
            addCriterion("c_update_time =", value, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeNotEqualTo(Date value) {
            addCriterion("c_update_time <>", value, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeGreaterThan(Date value) {
            addCriterion("c_update_time >", value, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_update_time >=", value, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeLessThan(Date value) {
            addCriterion("c_update_time <", value, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("c_update_time <=", value, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeIn(List<Date> values) {
            addCriterion("c_update_time in", values, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeNotIn(List<Date> values) {
            addCriterion("c_update_time not in", values, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeBetween(Date value1, Date value2) {
            addCriterion("c_update_time between", value1, value2, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("c_update_time not between", value1, value2, "c_update_time");
            return (Criteria) this;
        }

        public Criteria andC_teacherIsNull() {
            addCriterion("c_teacher is null");
            return (Criteria) this;
        }

        public Criteria andC_teacherIsNotNull() {
            addCriterion("c_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andC_teacherEqualTo(Integer value) {
            addCriterion("c_teacher =", value, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherNotEqualTo(Integer value) {
            addCriterion("c_teacher <>", value, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherGreaterThan(Integer value) {
            addCriterion("c_teacher >", value, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_teacher >=", value, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherLessThan(Integer value) {
            addCriterion("c_teacher <", value, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherLessThanOrEqualTo(Integer value) {
            addCriterion("c_teacher <=", value, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherIn(List<Integer> values) {
            addCriterion("c_teacher in", values, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherNotIn(List<Integer> values) {
            addCriterion("c_teacher not in", values, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherBetween(Integer value1, Integer value2) {
            addCriterion("c_teacher between", value1, value2, "c_teacher");
            return (Criteria) this;
        }

        public Criteria andC_teacherNotBetween(Integer value1, Integer value2) {
            addCriterion("c_teacher not between", value1, value2, "c_teacher");
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