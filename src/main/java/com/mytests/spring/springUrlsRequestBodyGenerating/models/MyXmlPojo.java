package com.mytests.spring.springUrlsRequestBodyGenerating.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "pojo")
@XmlAccessorType(XmlAccessType.NONE)
public class MyXmlPojo implements Serializable {

    @XmlElement(name="first")
    String firstElement;
    @XmlElement(name="second")
    String secondElement;

    public String getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(String firstElement) {
        this.firstElement = firstElement;
    }

    public String getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(String secondElement) {
        this.secondElement = secondElement;
    }


    @Override
    public String toString() {
        return "MyXmlPojo{" +
                "firstElement='" + firstElement + '\'' +
                ", secondElement='" + secondElement + '\'' +
                '}';
    }
}
