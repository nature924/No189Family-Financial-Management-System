package com.example.cwgl.utils;

import java.util.List;


public class Result<T> {

    private int code;   //状态码
    private String msg; //提示信息
    private T data; //数据
    private List<T> datas;  //多条数据
    private int total;  //分页获取数据时，存储符合程序条件的数据总量


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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}

