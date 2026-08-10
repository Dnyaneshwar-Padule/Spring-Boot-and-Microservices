package com.tca.model;

public class Student {

    private Integer rno;
    private String name;
    private Double per;

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public void setPer(Double per) {
        this.per = per;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRno() {
        return rno;
    }

    public String getName() {
        return name;
    }

    public Double getPer() {
        return per;
    }

}
