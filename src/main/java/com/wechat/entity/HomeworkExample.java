package com.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeworkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public HomeworkExample() {
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

        public Criteria andH_idIsNull() {
            addCriterion("h_id is null");
            return (Criteria) this;
        }

        public Criteria andH_idIsNotNull() {
            addCriterion("h_id is not null");
            return (Criteria) this;
        }

        public Criteria andH_idEqualTo(Integer value) {
            addCriterion("h_id =", value, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idNotEqualTo(Integer value) {
            addCriterion("h_id <>", value, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idGreaterThan(Integer value) {
            addCriterion("h_id >", value, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("h_id >=", value, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idLessThan(Integer value) {
            addCriterion("h_id <", value, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idLessThanOrEqualTo(Integer value) {
            addCriterion("h_id <=", value, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idIn(List<Integer> values) {
            addCriterion("h_id in", values, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idNotIn(List<Integer> values) {
            addCriterion("h_id not in", values, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idBetween(Integer value1, Integer value2) {
            addCriterion("h_id between", value1, value2, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_idNotBetween(Integer value1, Integer value2) {
            addCriterion("h_id not between", value1, value2, "h_id");
            return (Criteria) this;
        }

        public Criteria andH_titleIsNull() {
            addCriterion("h_title is null");
            return (Criteria) this;
        }

        public Criteria andH_titleIsNotNull() {
            addCriterion("h_title is not null");
            return (Criteria) this;
        }

        public Criteria andH_titleEqualTo(String value) {
            addCriterion("h_title =", value, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleNotEqualTo(String value) {
            addCriterion("h_title <>", value, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleGreaterThan(String value) {
            addCriterion("h_title >", value, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleGreaterThanOrEqualTo(String value) {
            addCriterion("h_title >=", value, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleLessThan(String value) {
            addCriterion("h_title <", value, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleLessThanOrEqualTo(String value) {
            addCriterion("h_title <=", value, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleLike(String value) {
            addCriterion("h_title like", value, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleNotLike(String value) {
            addCriterion("h_title not like", value, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleIn(List<String> values) {
            addCriterion("h_title in", values, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleNotIn(List<String> values) {
            addCriterion("h_title not in", values, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleBetween(String value1, String value2) {
            addCriterion("h_title between", value1, value2, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_titleNotBetween(String value1, String value2) {
            addCriterion("h_title not between", value1, value2, "h_title");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeIsNull() {
            addCriterion("h_finsh_time is null");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeIsNotNull() {
            addCriterion("h_finsh_time is not null");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeEqualTo(Date value) {
            addCriterion("h_finsh_time =", value, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeNotEqualTo(Date value) {
            addCriterion("h_finsh_time <>", value, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeGreaterThan(Date value) {
            addCriterion("h_finsh_time >", value, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("h_finsh_time >=", value, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeLessThan(Date value) {
            addCriterion("h_finsh_time <", value, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeLessThanOrEqualTo(Date value) {
            addCriterion("h_finsh_time <=", value, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeIn(List<Date> values) {
            addCriterion("h_finsh_time in", values, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeNotIn(List<Date> values) {
            addCriterion("h_finsh_time not in", values, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeBetween(Date value1, Date value2) {
            addCriterion("h_finsh_time between", value1, value2, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_finsh_timeNotBetween(Date value1, Date value2) {
            addCriterion("h_finsh_time not between", value1, value2, "h_finsh_time");
            return (Criteria) this;
        }

        public Criteria andH_teacherIsNull() {
            addCriterion("h_teacher is null");
            return (Criteria) this;
        }

        public Criteria andH_teacherIsNotNull() {
            addCriterion("h_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andH_teacherEqualTo(Integer value) {
            addCriterion("h_teacher =", value, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherNotEqualTo(Integer value) {
            addCriterion("h_teacher <>", value, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherGreaterThan(Integer value) {
            addCriterion("h_teacher >", value, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherGreaterThanOrEqualTo(Integer value) {
            addCriterion("h_teacher >=", value, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherLessThan(Integer value) {
            addCriterion("h_teacher <", value, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherLessThanOrEqualTo(Integer value) {
            addCriterion("h_teacher <=", value, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherIn(List<Integer> values) {
            addCriterion("h_teacher in", values, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherNotIn(List<Integer> values) {
            addCriterion("h_teacher not in", values, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherBetween(Integer value1, Integer value2) {
            addCriterion("h_teacher between", value1, value2, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_teacherNotBetween(Integer value1, Integer value2) {
            addCriterion("h_teacher not between", value1, value2, "h_teacher");
            return (Criteria) this;
        }

        public Criteria andH_classIsNull() {
            addCriterion("h_class is null");
            return (Criteria) this;
        }

        public Criteria andH_classIsNotNull() {
            addCriterion("h_class is not null");
            return (Criteria) this;
        }

        public Criteria andH_classEqualTo(Integer value) {
            addCriterion("h_class =", value, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classNotEqualTo(Integer value) {
            addCriterion("h_class <>", value, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classGreaterThan(Integer value) {
            addCriterion("h_class >", value, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classGreaterThanOrEqualTo(Integer value) {
            addCriterion("h_class >=", value, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classLessThan(Integer value) {
            addCriterion("h_class <", value, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classLessThanOrEqualTo(Integer value) {
            addCriterion("h_class <=", value, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classIn(List<Integer> values) {
            addCriterion("h_class in", values, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classNotIn(List<Integer> values) {
            addCriterion("h_class not in", values, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classBetween(Integer value1, Integer value2) {
            addCriterion("h_class between", value1, value2, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_classNotBetween(Integer value1, Integer value2) {
            addCriterion("h_class not between", value1, value2, "h_class");
            return (Criteria) this;
        }

        public Criteria andH_create_timeIsNull() {
            addCriterion("h_create_time is null");
            return (Criteria) this;
        }

        public Criteria andH_create_timeIsNotNull() {
            addCriterion("h_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andH_create_timeEqualTo(Date value) {
            addCriterion("h_create_time =", value, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeNotEqualTo(Date value) {
            addCriterion("h_create_time <>", value, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeGreaterThan(Date value) {
            addCriterion("h_create_time >", value, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("h_create_time >=", value, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeLessThan(Date value) {
            addCriterion("h_create_time <", value, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("h_create_time <=", value, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeIn(List<Date> values) {
            addCriterion("h_create_time in", values, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeNotIn(List<Date> values) {
            addCriterion("h_create_time not in", values, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeBetween(Date value1, Date value2) {
            addCriterion("h_create_time between", value1, value2, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("h_create_time not between", value1, value2, "h_create_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeIsNull() {
            addCriterion("h_update_time is null");
            return (Criteria) this;
        }

        public Criteria andH_update_timeIsNotNull() {
            addCriterion("h_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andH_update_timeEqualTo(Date value) {
            addCriterion("h_update_time =", value, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeNotEqualTo(Date value) {
            addCriterion("h_update_time <>", value, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeGreaterThan(Date value) {
            addCriterion("h_update_time >", value, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("h_update_time >=", value, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeLessThan(Date value) {
            addCriterion("h_update_time <", value, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("h_update_time <=", value, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeIn(List<Date> values) {
            addCriterion("h_update_time in", values, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeNotIn(List<Date> values) {
            addCriterion("h_update_time not in", values, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeBetween(Date value1, Date value2) {
            addCriterion("h_update_time between", value1, value2, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("h_update_time not between", value1, value2, "h_update_time");
            return (Criteria) this;
        }

        public Criteria andH_titleLikeInsensitive(String value) {
            addCriterion("upper(h_title) like", value.toUpperCase(), "h_title");
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