package com.mytests.spring.springUrlsRequestBodyGenerating.models;


public class MyPojoWithPojoRef {

    String firstProp;
    String secondProp;
    MyPojo pojo;

    public MyPojo getPojo() {
        return pojo;
    }

    public void setPojo(MyPojo pojo) {
        this.pojo = pojo;
    }

    public String getFirstProp() {
        return firstProp;
    }

    public void setFirstProp(String firstProp) {
        this.firstProp = firstProp;
    }

    public String getSecondProp() {
        return secondProp;
    }

    public void setSecondProp(String secondProp) {
        this.secondProp = secondProp;
    }

    @Override
    public String toString() {
        return "MyPojoWithPojoRef{" +
                "firstProp='" + firstProp + '\'' +
                ", secondProp='" + secondProp + '\'' +
                ", pojo=" + pojo +
                '}';
    }
}
