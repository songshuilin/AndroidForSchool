package com.example.edu.androidforschool.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/9.
 */

public class PhoneInfo{
    private String name;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PhoneInfo{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
