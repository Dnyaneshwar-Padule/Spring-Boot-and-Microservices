package com.tca.model;

public class Student {

    private Integer rno;
    private String name;
    private Double per;
    private String city;

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "rno=" + rno +
                ", name='" + name + '\'' +
                ", per=" + per +
                '}';
    }


}
