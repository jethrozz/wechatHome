package com.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public StudentExample() {
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

        public Criteria andS_idIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andS_idIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andS_idEqualTo(Integer value) {
            addCriterion("s_id =", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idGreaterThan(Integer value) {
            addCriterion("s_id >", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idLessThan(Integer value) {
            addCriterion("s_id <", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idIn(List<Integer> values) {
            addCriterion("s_id in", values, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "s_id");
            return (Criteria) this;
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

        public Criteria andS_nameIsNull() {
            addCriterion("s_name is null");
            return (Criteria) this;
        }

        public Criteria andS_nameIsNotNull() {
            addCriterion("s_name is not null");
            return (Criteria) this;
        }

        public Criteria andS_nameEqualTo(String value) {
            addCriterion("s_name =", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotEqualTo(String value) {
            addCriterion("s_name <>", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameGreaterThan(String value) {
            addCriterion("s_name >", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameGreaterThanOrEqualTo(String value) {
            addCriterion("s_name >=", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLessThan(String value) {
            addCriterion("s_name <", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLessThanOrEqualTo(String value) {
            addCriterion("s_name <=", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLike(String value) {
            addCriterion("s_name like", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotLike(String value) {
            addCriterion("s_name not like", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameIn(List<String> values) {
            addCriterion("s_name in", values, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotIn(List<String> values) {
            addCriterion("s_name not in", values, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameBetween(String value1, String value2) {
            addCriterion("s_name between", value1, value2, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotBetween(String value1, String value2) {
            addCriterion("s_name not between", value1, value2, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_sexIsNull() {
            addCriterion("s_sex is null");
            return (Criteria) this;
        }

        public Criteria andS_sexIsNotNull() {
            addCriterion("s_sex is not null");
            return (Criteria) this;
        }

        public Criteria andS_sexEqualTo(Integer value) {
            addCriterion("s_sex =", value, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexNotEqualTo(Integer value) {
            addCriterion("s_sex <>", value, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexGreaterThan(Integer value) {
            addCriterion("s_sex >", value, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_sex >=", value, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexLessThan(Integer value) {
            addCriterion("s_sex <", value, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexLessThanOrEqualTo(Integer value) {
            addCriterion("s_sex <=", value, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexIn(List<Integer> values) {
            addCriterion("s_sex in", values, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexNotIn(List<Integer> values) {
            addCriterion("s_sex not in", values, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexBetween(Integer value1, Integer value2) {
            addCriterion("s_sex between", value1, value2, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_sexNotBetween(Integer value1, Integer value2) {
            addCriterion("s_sex not between", value1, value2, "s_sex");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberIsNull() {
            addCriterion("s_identity_number is null");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberIsNotNull() {
            addCriterion("s_identity_number is not null");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberEqualTo(String value) {
            addCriterion("s_identity_number =", value, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberNotEqualTo(String value) {
            addCriterion("s_identity_number <>", value, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberGreaterThan(String value) {
            addCriterion("s_identity_number >", value, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberGreaterThanOrEqualTo(String value) {
            addCriterion("s_identity_number >=", value, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberLessThan(String value) {
            addCriterion("s_identity_number <", value, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberLessThanOrEqualTo(String value) {
            addCriterion("s_identity_number <=", value, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberLike(String value) {
            addCriterion("s_identity_number like", value, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberNotLike(String value) {
            addCriterion("s_identity_number not like", value, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberIn(List<String> values) {
            addCriterion("s_identity_number in", values, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberNotIn(List<String> values) {
            addCriterion("s_identity_number not in", values, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberBetween(String value1, String value2) {
            addCriterion("s_identity_number between", value1, value2, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberNotBetween(String value1, String value2) {
            addCriterion("s_identity_number not between", value1, value2, "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberIsNull() {
            addCriterion("s_student_number is null");
            return (Criteria) this;
        }

        public Criteria andS_student_numberIsNotNull() {
            addCriterion("s_student_number is not null");
            return (Criteria) this;
        }

        public Criteria andS_student_numberEqualTo(String value) {
            addCriterion("s_student_number =", value, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberNotEqualTo(String value) {
            addCriterion("s_student_number <>", value, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberGreaterThan(String value) {
            addCriterion("s_student_number >", value, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberGreaterThanOrEqualTo(String value) {
            addCriterion("s_student_number >=", value, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberLessThan(String value) {
            addCriterion("s_student_number <", value, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberLessThanOrEqualTo(String value) {
            addCriterion("s_student_number <=", value, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberLike(String value) {
            addCriterion("s_student_number like", value, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberNotLike(String value) {
            addCriterion("s_student_number not like", value, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberIn(List<String> values) {
            addCriterion("s_student_number in", values, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberNotIn(List<String> values) {
            addCriterion("s_student_number not in", values, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberBetween(String value1, String value2) {
            addCriterion("s_student_number between", value1, value2, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberNotBetween(String value1, String value2) {
            addCriterion("s_student_number not between", value1, value2, "s_student_number");
            return (Criteria) this;
        }

        public Criteria andS_create_timeIsNull() {
            addCriterion("s_create_time is null");
            return (Criteria) this;
        }

        public Criteria andS_create_timeIsNotNull() {
            addCriterion("s_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andS_create_timeEqualTo(Date value) {
            addCriterion("s_create_time =", value, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeNotEqualTo(Date value) {
            addCriterion("s_create_time <>", value, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeGreaterThan(Date value) {
            addCriterion("s_create_time >", value, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("s_create_time >=", value, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeLessThan(Date value) {
            addCriterion("s_create_time <", value, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("s_create_time <=", value, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeIn(List<Date> values) {
            addCriterion("s_create_time in", values, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeNotIn(List<Date> values) {
            addCriterion("s_create_time not in", values, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeBetween(Date value1, Date value2) {
            addCriterion("s_create_time between", value1, value2, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("s_create_time not between", value1, value2, "s_create_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeIsNull() {
            addCriterion("s_update_time is null");
            return (Criteria) this;
        }

        public Criteria andS_update_timeIsNotNull() {
            addCriterion("s_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andS_update_timeEqualTo(Date value) {
            addCriterion("s_update_time =", value, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeNotEqualTo(Date value) {
            addCriterion("s_update_time <>", value, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeGreaterThan(Date value) {
            addCriterion("s_update_time >", value, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("s_update_time >=", value, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeLessThan(Date value) {
            addCriterion("s_update_time <", value, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("s_update_time <=", value, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeIn(List<Date> values) {
            addCriterion("s_update_time in", values, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeNotIn(List<Date> values) {
            addCriterion("s_update_time not in", values, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeBetween(Date value1, Date value2) {
            addCriterion("s_update_time between", value1, value2, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("s_update_time not between", value1, value2, "s_update_time");
            return (Criteria) this;
        }

        public Criteria andS_nameLikeInsensitive(String value) {
            addCriterion("upper(s_name) like", value.toUpperCase(), "s_name");
            return (Criteria) this;
        }

        public Criteria andS_identity_numberLikeInsensitive(String value) {
            addCriterion("upper(s_identity_number) like", value.toUpperCase(), "s_identity_number");
            return (Criteria) this;
        }

        public Criteria andS_student_numberLikeInsensitive(String value) {
            addCriterion("upper(s_student_number) like", value.toUpperCase(), "s_student_number");
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