package com.wujq.domain;

public class Good {

    private Integer good_id;
    private String good_name;
    private Integer fk_type_id;
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getFk_type_id() {
        return fk_type_id;
    }

    @Override
    public String toString() {
        return "Good{" +
                "good_id=" + good_id +
                ", good_name='" + good_name + '\'' +
                ", fk_type_id=" + fk_type_id +
                ", type=" + type +
                ", good_price=" + good_price +
                '}';
    }

    public void setFk_type_id(Integer fk_type_id) {
        this.fk_type_id = fk_type_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public Float getGood_price() {
        return good_price;
    }

    public void setGood_price(Float good_price) {
        this.good_price = good_price;
    }

    private Float good_price;

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }
}
