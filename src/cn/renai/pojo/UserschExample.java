package cn.renai.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserschExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserschExample() {
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

        public Criteria andUScIsNull() {
            addCriterion("U_SC is null");
            return (Criteria) this;
        }

        public Criteria andUScIsNotNull() {
            addCriterion("U_SC is not null");
            return (Criteria) this;
        }

        public Criteria andUScEqualTo(String value) {
            addCriterion("U_SC =", value, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScNotEqualTo(String value) {
            addCriterion("U_SC <>", value, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScGreaterThan(String value) {
            addCriterion("U_SC >", value, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScGreaterThanOrEqualTo(String value) {
            addCriterion("U_SC >=", value, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScLessThan(String value) {
            addCriterion("U_SC <", value, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScLessThanOrEqualTo(String value) {
            addCriterion("U_SC <=", value, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScLike(String value) {
            addCriterion("U_SC like", value, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScNotLike(String value) {
            addCriterion("U_SC not like", value, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScIn(List<String> values) {
            addCriterion("U_SC in", values, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScNotIn(List<String> values) {
            addCriterion("U_SC not in", values, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScBetween(String value1, String value2) {
            addCriterion("U_SC between", value1, value2, "uSc");
            return (Criteria) this;
        }

        public Criteria andUScNotBetween(String value1, String value2) {
            addCriterion("U_SC not between", value1, value2, "uSc");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("U_ID is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("U_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(String value) {
            addCriterion("U_ID =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(String value) {
            addCriterion("U_ID <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(String value) {
            addCriterion("U_ID >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(String value) {
            addCriterion("U_ID >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(String value) {
            addCriterion("U_ID <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(String value) {
            addCriterion("U_ID <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLike(String value) {
            addCriterion("U_ID like", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotLike(String value) {
            addCriterion("U_ID not like", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<String> values) {
            addCriterion("U_ID in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<String> values) {
            addCriterion("U_ID not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(String value1, String value2) {
            addCriterion("U_ID between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(String value1, String value2) {
            addCriterion("U_ID not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andIsrenaiIsNull() {
            addCriterion("ISRENAI is null");
            return (Criteria) this;
        }

        public Criteria andIsrenaiIsNotNull() {
            addCriterion("ISRENAI is not null");
            return (Criteria) this;
        }

        public Criteria andIsrenaiEqualTo(Integer value) {
            addCriterion("ISRENAI =", value, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiNotEqualTo(Integer value) {
            addCriterion("ISRENAI <>", value, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiGreaterThan(Integer value) {
            addCriterion("ISRENAI >", value, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISRENAI >=", value, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiLessThan(Integer value) {
            addCriterion("ISRENAI <", value, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiLessThanOrEqualTo(Integer value) {
            addCriterion("ISRENAI <=", value, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiIn(List<Integer> values) {
            addCriterion("ISRENAI in", values, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiNotIn(List<Integer> values) {
            addCriterion("ISRENAI not in", values, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiBetween(Integer value1, Integer value2) {
            addCriterion("ISRENAI between", value1, value2, "isrenai");
            return (Criteria) this;
        }

        public Criteria andIsrenaiNotBetween(Integer value1, Integer value2) {
            addCriterion("ISRENAI not between", value1, value2, "isrenai");
            return (Criteria) this;
        }

        public Criteria andSchaIsNull() {
            addCriterion("SCHA is null");
            return (Criteria) this;
        }

        public Criteria andSchaIsNotNull() {
            addCriterion("SCHA is not null");
            return (Criteria) this;
        }

        public Criteria andSchaEqualTo(Integer value) {
            addCriterion("SCHA =", value, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaNotEqualTo(Integer value) {
            addCriterion("SCHA <>", value, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaGreaterThan(Integer value) {
            addCriterion("SCHA >", value, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCHA >=", value, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaLessThan(Integer value) {
            addCriterion("SCHA <", value, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaLessThanOrEqualTo(Integer value) {
            addCriterion("SCHA <=", value, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaIn(List<Integer> values) {
            addCriterion("SCHA in", values, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaNotIn(List<Integer> values) {
            addCriterion("SCHA not in", values, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaBetween(Integer value1, Integer value2) {
            addCriterion("SCHA between", value1, value2, "scha");
            return (Criteria) this;
        }

        public Criteria andSchaNotBetween(Integer value1, Integer value2) {
            addCriterion("SCHA not between", value1, value2, "scha");
            return (Criteria) this;
        }

        public Criteria andSchbIsNull() {
            addCriterion("SCHB is null");
            return (Criteria) this;
        }

        public Criteria andSchbIsNotNull() {
            addCriterion("SCHB is not null");
            return (Criteria) this;
        }

        public Criteria andSchbEqualTo(Integer value) {
            addCriterion("SCHB =", value, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbNotEqualTo(Integer value) {
            addCriterion("SCHB <>", value, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbGreaterThan(Integer value) {
            addCriterion("SCHB >", value, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCHB >=", value, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbLessThan(Integer value) {
            addCriterion("SCHB <", value, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbLessThanOrEqualTo(Integer value) {
            addCriterion("SCHB <=", value, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbIn(List<Integer> values) {
            addCriterion("SCHB in", values, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbNotIn(List<Integer> values) {
            addCriterion("SCHB not in", values, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbBetween(Integer value1, Integer value2) {
            addCriterion("SCHB between", value1, value2, "schb");
            return (Criteria) this;
        }

        public Criteria andSchbNotBetween(Integer value1, Integer value2) {
            addCriterion("SCHB not between", value1, value2, "schb");
            return (Criteria) this;
        }

        public Criteria andSchcIsNull() {
            addCriterion("SCHC is null");
            return (Criteria) this;
        }

        public Criteria andSchcIsNotNull() {
            addCriterion("SCHC is not null");
            return (Criteria) this;
        }

        public Criteria andSchcEqualTo(Integer value) {
            addCriterion("SCHC =", value, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcNotEqualTo(Integer value) {
            addCriterion("SCHC <>", value, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcGreaterThan(Integer value) {
            addCriterion("SCHC >", value, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCHC >=", value, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcLessThan(Integer value) {
            addCriterion("SCHC <", value, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcLessThanOrEqualTo(Integer value) {
            addCriterion("SCHC <=", value, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcIn(List<Integer> values) {
            addCriterion("SCHC in", values, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcNotIn(List<Integer> values) {
            addCriterion("SCHC not in", values, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcBetween(Integer value1, Integer value2) {
            addCriterion("SCHC between", value1, value2, "schc");
            return (Criteria) this;
        }

        public Criteria andSchcNotBetween(Integer value1, Integer value2) {
            addCriterion("SCHC not between", value1, value2, "schc");
            return (Criteria) this;
        }

        public Criteria andSchdIsNull() {
            addCriterion("SCHD is null");
            return (Criteria) this;
        }

        public Criteria andSchdIsNotNull() {
            addCriterion("SCHD is not null");
            return (Criteria) this;
        }

        public Criteria andSchdEqualTo(Integer value) {
            addCriterion("SCHD =", value, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdNotEqualTo(Integer value) {
            addCriterion("SCHD <>", value, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdGreaterThan(Integer value) {
            addCriterion("SCHD >", value, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCHD >=", value, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdLessThan(Integer value) {
            addCriterion("SCHD <", value, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdLessThanOrEqualTo(Integer value) {
            addCriterion("SCHD <=", value, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdIn(List<Integer> values) {
            addCriterion("SCHD in", values, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdNotIn(List<Integer> values) {
            addCriterion("SCHD not in", values, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdBetween(Integer value1, Integer value2) {
            addCriterion("SCHD between", value1, value2, "schd");
            return (Criteria) this;
        }

        public Criteria andSchdNotBetween(Integer value1, Integer value2) {
            addCriterion("SCHD not between", value1, value2, "schd");
            return (Criteria) this;
        }

        public Criteria andScheIsNull() {
            addCriterion("SCHE is null");
            return (Criteria) this;
        }

        public Criteria andScheIsNotNull() {
            addCriterion("SCHE is not null");
            return (Criteria) this;
        }

        public Criteria andScheEqualTo(Integer value) {
            addCriterion("SCHE =", value, "sche");
            return (Criteria) this;
        }

        public Criteria andScheNotEqualTo(Integer value) {
            addCriterion("SCHE <>", value, "sche");
            return (Criteria) this;
        }

        public Criteria andScheGreaterThan(Integer value) {
            addCriterion("SCHE >", value, "sche");
            return (Criteria) this;
        }

        public Criteria andScheGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCHE >=", value, "sche");
            return (Criteria) this;
        }

        public Criteria andScheLessThan(Integer value) {
            addCriterion("SCHE <", value, "sche");
            return (Criteria) this;
        }

        public Criteria andScheLessThanOrEqualTo(Integer value) {
            addCriterion("SCHE <=", value, "sche");
            return (Criteria) this;
        }

        public Criteria andScheIn(List<Integer> values) {
            addCriterion("SCHE in", values, "sche");
            return (Criteria) this;
        }

        public Criteria andScheNotIn(List<Integer> values) {
            addCriterion("SCHE not in", values, "sche");
            return (Criteria) this;
        }

        public Criteria andScheBetween(Integer value1, Integer value2) {
            addCriterion("SCHE between", value1, value2, "sche");
            return (Criteria) this;
        }

        public Criteria andScheNotBetween(Integer value1, Integer value2) {
            addCriterion("SCHE not between", value1, value2, "sche");
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