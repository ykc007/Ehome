package com.fly.tour.api.entity;

public class BaseEntity {
    public String code_key;
    public int code;
    public String msg;

    public String getCode_key() {
        return code_key;
    }

    public void setCode_key(String code_key) {
        this.code_key = code_key;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "code_key='" + code_key + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
