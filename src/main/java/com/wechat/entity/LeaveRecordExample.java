package com.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LeaveRecordExample() {
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

        public Criteria andL_idIsNull() {
            addCriterion("l_id is null");
            return (Criteria) this;
        }

        public Criteria andL_idIsNotNull() {
            addCriterion("l_id is not null");
            return (Criteria) this;
        }

        public Criteria andL_idEqualTo(Integer value) {
            addCriterion("l_id =", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idNotEqualTo(Integer value) {
            addCriterion("l_id <>", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idGreaterThan(Integer value) {
            addCriterion("l_id >", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_id >=", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idLessThan(Integer value) {
            addCriterion("l_id <", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idLessThanOrEqualTo(Integer value) {
            addCriterion("l_id <=", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idIn(List<Integer> values) {
            addCriterion("l_id in", values, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idNotIn(List<Integer> values) {
            addCriterion("l_id not in", values, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idBetween(Integer value1, Integer value2) {
            addCriterion("l_id between", value1, value2, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idNotBetween(Integer value1, Integer value2) {
            addCriterion("l_id not between", value1, value2, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_studentIsNull() {
            addCriterion("l_student is null");
            return (Criteria) this;
        }

        public Criteria andL_studentIsNotNull() {
            addCriterion("l_student is not null");
            return (Criteria) this;
        }

        public Criteria andL_studentEqualTo(Integer value) {
            addCriterion("l_student =", value, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentNotEqualTo(Integer value) {
            addCriterion("l_student <>", value, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentGreaterThan(Integer value) {
            addCriterion("l_student >", value, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_student >=", value, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentLessThan(Integer value) {
            addCriterion("l_student <", value, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentLessThanOrEqualTo(Integer value) {
            addCriterion("l_student <=", value, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentIn(List<Integer> values) {
            addCriterion("l_student in", values, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentNotIn(List<Integer> values) {
            addCriterion("l_student not in", values, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentBetween(Integer value1, Integer value2) {
            addCriterion("l_student between", value1, value2, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_studentNotBetween(Integer value1, Integer value2) {
            addCriterion("l_student not between", value1, value2, "l_student");
            return (Criteria) this;
        }

        public Criteria andL_teacherIsNull() {
            addCriterion("l_teacher is null");
            return (Criteria) this;
        }

        public Criteria andL_teacherIsNotNull() {
            addCriterion("l_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andL_teacherEqualTo(Integer value) {
            addCriterion("l_teacher =", value, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherNotEqualTo(Integer value) {
            addCriterion("l_teacher <>", value, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherGreaterThan(Integer value) {
            addCriterion("l_teacher >", value, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_teacher >=", value, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherLessThan(Integer value) {
            addCriterion("l_teacher <", value, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherLessThanOrEqualTo(Integer value) {
            addCriterion("l_teacher <=", value, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherIn(List<Integer> values) {
            addCriterion("l_teacher in", values, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherNotIn(List<Integer> values) {
            addCriterion("l_teacher not in", values, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherBetween(Integer value1, Integer value2) {
            addCriterion("l_teacher between", value1, value2, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_teacherNotBetween(Integer value1, Integer value2) {
            addCriterion("l_teacher not between", value1, value2, "l_teacher");
            return (Criteria) this;
        }

        public Criteria andL_reasonIsNull() {
            addCriterion("l_reason is null");
            return (Criteria) this;
        }

        public Criteria andL_reasonIsNotNull() {
            addCriterion("l_reason is not null");
            return (Criteria) this;
        }

        public Criteria andL_reasonEqualTo(String value) {
            addCriterion("l_reason =", value, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonNotEqualTo(String value) {
            addCriterion("l_reason <>", value, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonGreaterThan(String value) {
            addCriterion("l_reason >", value, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonGreaterThanOrEqualTo(String value) {
            addCriterion("l_reason >=", value, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonLessThan(String value) {
            addCriterion("l_reason <", value, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonLessThanOrEqualTo(String value) {
            addCriterion("l_reason <=", value, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonLike(String value) {
            addCriterion("l_reason like", value, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonNotLike(String value) {
            addCriterion("l_reason not like", value, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonIn(List<String> values) {
            addCriterion("l_reason in", values, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonNotIn(List<String> values) {
            addCriterion("l_reason not in", values, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonBetween(String value1, String value2) {
            addCriterion("l_reason between", value1, value2, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_reasonNotBetween(String value1, String value2) {
            addCriterion("l_reason not between", value1, value2, "l_reason");
            return (Criteria) this;
        }

        public Criteria andL_typeIsNull() {
            addCriterion("l_type is null");
            return (Criteria) this;
        }

        public Criteria andL_typeIsNotNull() {
            addCriterion("l_type is not null");
            return (Criteria) this;
        }

        public Criteria andL_typeEqualTo(Integer value) {
            addCriterion("l_type =", value, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeNotEqualTo(Integer value) {
            addCriterion("l_type <>", value, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeGreaterThan(Integer value) {
            addCriterion("l_type >", value, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_type >=", value, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeLessThan(Integer value) {
            addCriterion("l_type <", value, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeLessThanOrEqualTo(Integer value) {
            addCriterion("l_type <=", value, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeIn(List<Integer> values) {
            addCriterion("l_type in", values, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeNotIn(List<Integer> values) {
            addCriterion("l_type not in", values, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeBetween(Integer value1, Integer value2) {
            addCriterion("l_type between", value1, value2, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("l_type not between", value1, value2, "l_type");
            return (Criteria) this;
        }

        public Criteria andL_start_timeIsNull() {
            addCriterion("l_start_time is null");
            return (Criteria) this;
        }

        public Criteria andL_start_timeIsNotNull() {
            addCriterion("l_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andL_start_timeEqualTo(Date value) {
            addCriterion("l_start_time =", value, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeNotEqualTo(Date value) {
            addCriterion("l_start_time <>", value, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeGreaterThan(Date value) {
            addCriterion("l_start_time >", value, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("l_start_time >=", value, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeLessThan(Date value) {
            addCriterion("l_start_time <", value, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeLessThanOrEqualTo(Date value) {
            addCriterion("l_start_time <=", value, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeIn(List<Date> values) {
            addCriterion("l_start_time in", values, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeNotIn(List<Date> values) {
            addCriterion("l_start_time not in", values, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeBetween(Date value1, Date value2) {
            addCriterion("l_start_time between", value1, value2, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_start_timeNotBetween(Date value1, Date value2) {
            addCriterion("l_start_time not between", value1, value2, "l_start_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeIsNull() {
            addCriterion("l_end_time is null");
            return (Criteria) this;
        }

        public Criteria andL_end_timeIsNotNull() {
            addCriterion("l_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andL_end_timeEqualTo(Date value) {
            addCriterion("l_end_time =", value, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeNotEqualTo(Date value) {
            addCriterion("l_end_time <>", value, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeGreaterThan(Date value) {
            addCriterion("l_end_time >", value, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("l_end_time >=", value, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeLessThan(Date value) {
            addCriterion("l_end_time <", value, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeLessThanOrEqualTo(Date value) {
            addCriterion("l_end_time <=", value, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeIn(List<Date> values) {
            addCriterion("l_end_time in", values, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeNotIn(List<Date> values) {
            addCriterion("l_end_time not in", values, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeBetween(Date value1, Date value2) {
            addCriterion("l_end_time between", value1, value2, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_end_timeNotBetween(Date value1, Date value2) {
            addCriterion("l_end_time not between", value1, value2, "l_end_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeIsNull() {
            addCriterion("l_create_time is null");
            return (Criteria) this;
        }

        public Criteria andL_create_timeIsNotNull() {
            addCriterion("l_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andL_create_timeEqualTo(Date value) {
            addCriterion("l_create_time =", value, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeNotEqualTo(Date value) {
            addCriterion("l_create_time <>", value, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeGreaterThan(Date value) {
            addCriterion("l_create_time >", value, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("l_create_time >=", value, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeLessThan(Date value) {
            addCriterion("l_create_time <", value, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("l_create_time <=", value, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeIn(List<Date> values) {
            addCriterion("l_create_time in", values, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeNotIn(List<Date> values) {
            addCriterion("l_create_time not in", values, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeBetween(Date value1, Date value2) {
            addCriterion("l_create_time between", value1, value2, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("l_create_time not between", value1, value2, "l_create_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeIsNull() {
            addCriterion("l_update_time is null");
            return (Criteria) this;
        }

        public Criteria andL_update_timeIsNotNull() {
            addCriterion("l_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andL_update_timeEqualTo(Date value) {
            addCriterion("l_update_time =", value, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeNotEqualTo(Date value) {
            addCriterion("l_update_time <>", value, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeGreaterThan(Date value) {
            addCriterion("l_update_time >", value, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("l_update_time >=", value, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeLessThan(Date value) {
            addCriterion("l_update_time <", value, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("l_update_time <=", value, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeIn(List<Date> values) {
            addCriterion("l_update_time in", values, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeNotIn(List<Date> values) {
            addCriterion("l_update_time not in", values, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeBetween(Date value1, Date value2) {
            addCriterion("l_update_time between", value1, value2, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("l_update_time not between", value1, value2, "l_update_time");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeIsNull() {
            addCriterion("l_is_agree is null");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeIsNotNull() {
            addCriterion("l_is_agree is not null");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeEqualTo(Integer value) {
            addCriterion("l_is_agree =", value, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeNotEqualTo(Integer value) {
            addCriterion("l_is_agree <>", value, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeGreaterThan(Integer value) {
            addCriterion("l_is_agree >", value, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_is_agree >=", value, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeLessThan(Integer value) {
            addCriterion("l_is_agree <", value, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeLessThanOrEqualTo(Integer value) {
            addCriterion("l_is_agree <=", value, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeIn(List<Integer> values) {
            addCriterion("l_is_agree in", values, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeNotIn(List<Integer> values) {
            addCriterion("l_is_agree not in", values, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeBetween(Integer value1, Integer value2) {
            addCriterion("l_is_agree between", value1, value2, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_is_agreeNotBetween(Integer value1, Integer value2) {
            addCriterion("l_is_agree not between", value1, value2, "l_is_agree");
            return (Criteria) this;
        }

        public Criteria andL_timeIsNull() {
            addCriterion("l_time is null");
            return (Criteria) this;
        }

        public Criteria andL_timeIsNotNull() {
            addCriterion("l_time is not null");
            return (Criteria) this;
        }

        public Criteria andL_timeEqualTo(Float value) {
            addCriterion("l_time =", value, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeNotEqualTo(Float value) {
            addCriterion("l_time <>", value, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeGreaterThan(Float value) {
            addCriterion("l_time >", value, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeGreaterThanOrEqualTo(Float value) {
            addCriterion("l_time >=", value, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeLessThan(Float value) {
            addCriterion("l_time <", value, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeLessThanOrEqualTo(Float value) {
            addCriterion("l_time <=", value, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeIn(List<Float> values) {
            addCriterion("l_time in", values, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeNotIn(List<Float> values) {
            addCriterion("l_time not in", values, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeBetween(Float value1, Float value2) {
            addCriterion("l_time between", value1, value2, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_timeNotBetween(Float value1, Float value2) {
            addCriterion("l_time not between", value1, value2, "l_time");
            return (Criteria) this;
        }

        public Criteria andL_reasonLikeInsensitive(String value) {
            addCriterion("upper(l_reason) like", value.toUpperCase(), "l_reason");
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