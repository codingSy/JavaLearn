package com.codingsy.javalearn.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 3331833818170697694L;
    private T data;
    private int code = 0;
    private String msg = "";
    private static final int SUCCESS_CODE = 0;

    public Result() {
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.code == 0;
    }

    public static Result wrapError(int code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result<T> wrapSuccess(T data) {
        Result<T> result = new Result();
        result.setData(data);
        return result;
    }

}