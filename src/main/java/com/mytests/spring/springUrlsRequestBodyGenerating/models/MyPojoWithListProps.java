package com.mytests.spring.springUrlsRequestBodyGenerating.models;


import java.util.List;

public class MyPojoWithListProps {

    String prop;
    List<String> stringList;
    List<MyPojo> pojoList;
    List<MyEnum> enumList;

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<MyPojo> getPojoList() {
        return pojoList;
    }

    public void setPojoList(List<MyPojo> pojoList) {
        this.pojoList = pojoList;
    }

    public List<MyEnum> getEnumList() {
        return enumList;
    }

    public void setEnumList(List<MyEnum> enumList) {
        this.enumList = enumList;
    }

    @Override
    public String toString() {
        return "MyPojoWithListProps{" +
                "prop='" + prop + '\'' +
                ", stringList=" + stringList +
                ", pojoList=" + pojoList +
                ", enumList=" + enumList +
                '}';
    }
}
