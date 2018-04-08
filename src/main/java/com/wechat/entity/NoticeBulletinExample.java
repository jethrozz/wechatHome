package com.wechat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeBulletinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public NoticeBulletinExample() {
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

        public Criteria andNb_idIsNull() {
            addCriterion("nb_id is null");
            return (Criteria) this;
        }

        public Criteria andNb_idIsNotNull() {
            addCriterion("nb_id is not null");
            return (Criteria) this;
        }

        public Criteria andNb_idEqualTo(Integer value) {
            addCriterion("nb_id =", value, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idNotEqualTo(Integer value) {
            addCriterion("nb_id <>", value, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idGreaterThan(Integer value) {
            addCriterion("nb_id >", value, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("nb_id >=", value, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idLessThan(Integer value) {
            addCriterion("nb_id <", value, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idLessThanOrEqualTo(Integer value) {
            addCriterion("nb_id <=", value, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idIn(List<Integer> values) {
            addCriterion("nb_id in", values, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idNotIn(List<Integer> values) {
            addCriterion("nb_id not in", values, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idBetween(Integer value1, Integer value2) {
            addCriterion("nb_id between", value1, value2, "nb_id");
            return (Criteria) this;
        }

        public Criteria andNb_idNotBetween(Integer value1, Integer value2) {
            addCriterion("nb_id not between", value1, value2, "nb_id");
            return (Criteria) this;
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

        public Criteria andNb_typeIsNull() {
            addCriterion("nb_type is null");
            return (Criteria) this;
        }

        public Criteria andNb_typeIsNotNull() {
            addCriterion("nb_type is not null");
            return (Criteria) this;
        }

        public Criteria andNb_typeEqualTo(Integer value) {
            addCriterion("nb_type =", value, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeNotEqualTo(Integer value) {
            addCriterion("nb_type <>", value, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeGreaterThan(Integer value) {
            addCriterion("nb_type >", value, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("nb_type >=", value, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeLessThan(Integer value) {
            addCriterion("nb_type <", value, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeLessThanOrEqualTo(Integer value) {
            addCriterion("nb_type <=", value, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeIn(List<Integer> values) {
            addCriterion("nb_type in", values, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeNotIn(List<Integer> values) {
            addCriterion("nb_type not in", values, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeBetween(Integer value1, Integer value2) {
            addCriterion("nb_type between", value1, value2, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("nb_type not between", value1, value2, "nb_type");
            return (Criteria) this;
        }

        public Criteria andNb_titleIsNull() {
            addCriterion("nb_title is null");
            return (Criteria) this;
        }

        public Criteria andNb_titleIsNotNull() {
            addCriterion("nb_title is not null");
            return (Criteria) this;
        }

        public Criteria andNb_titleEqualTo(String value) {
            addCriterion("nb_title =", value, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleNotEqualTo(String value) {
            addCriterion("nb_title <>", value, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleGreaterThan(String value) {
            addCriterion("nb_title >", value, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleGreaterThanOrEqualTo(String value) {
            addCriterion("nb_title >=", value, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleLessThan(String value) {
            addCriterion("nb_title <", value, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleLessThanOrEqualTo(String value) {
            addCriterion("nb_title <=", value, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleLike(String value) {
            addCriterion("nb_title like", value, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleNotLike(String value) {
            addCriterion("nb_title not like", value, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleIn(List<String> values) {
            addCriterion("nb_title in", values, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleNotIn(List<String> values) {
            addCriterion("nb_title not in", values, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleBetween(String value1, String value2) {
            addCriterion("nb_title between", value1, value2, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_titleNotBetween(String value1, String value2) {
            addCriterion("nb_title not between", value1, value2, "nb_title");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeIsNull() {
            addCriterion("nb_create_time is null");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeIsNotNull() {
            addCriterion("nb_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeEqualTo(Date value) {
            addCriterion("nb_create_time =", value, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeNotEqualTo(Date value) {
            addCriterion("nb_create_time <>", value, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeGreaterThan(Date value) {
            addCriterion("nb_create_time >", value, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("nb_create_time >=", value, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeLessThan(Date value) {
            addCriterion("nb_create_time <", value, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("nb_create_time <=", value, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeIn(List<Date> values) {
            addCriterion("nb_create_time in", values, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeNotIn(List<Date> values) {
            addCriterion("nb_create_time not in", values, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeBetween(Date value1, Date value2) {
            addCriterion("nb_create_time between", value1, value2, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("nb_create_time not between", value1, value2, "nb_create_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeIsNull() {
            addCriterion("nb_update_time is null");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeIsNotNull() {
            addCriterion("nb_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeEqualTo(Date value) {
            addCriterion("nb_update_time =", value, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeNotEqualTo(Date value) {
            addCriterion("nb_update_time <>", value, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeGreaterThan(Date value) {
            addCriterion("nb_update_time >", value, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("nb_update_time >=", value, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeLessThan(Date value) {
            addCriterion("nb_update_time <", value, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("nb_update_time <=", value, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeIn(List<Date> values) {
            addCriterion("nb_update_time in", values, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeNotIn(List<Date> values) {
            addCriterion("nb_update_time not in", values, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeBetween(Date value1, Date value2) {
            addCriterion("nb_update_time between", value1, value2, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("nb_update_time not between", value1, value2, "nb_update_time");
            return (Criteria) this;
        }

        public Criteria andNb_titleLikeInsensitive(String value) {
            addCriterion("upper(nb_title) like", value.toUpperCase(), "nb_title");
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