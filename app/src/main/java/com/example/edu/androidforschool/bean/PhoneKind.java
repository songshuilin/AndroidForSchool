package com.example.edu.androidforschool.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */

public class PhoneKind  {
    private String kind;
    private List<PhoneInfo>info;


    public List<PhoneInfo> getInfo() {
        return info;
    }

    public void setInfo(List<PhoneInfo> info) {
        this.info = info;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "PhoneKind{" +
                "kind='" + kind + '\'' +
                ", info=" + info +
                '}';
    }
}
