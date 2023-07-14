package com.mytests.spring.springUrlsRequestBodyGenerating.models;


public class MyPojoWithEnumRef {

    int id;
    boolean flag;
    MyEnum myEnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }

    @Override
    public String toString() {
        return "MyPojoWithEnumRef{" +
                "id=" + id +
                ", flag=" + flag +
                ", myEnum=" + myEnum +
                '}';
    }
}
