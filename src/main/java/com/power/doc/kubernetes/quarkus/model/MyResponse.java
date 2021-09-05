package com.power.doc.kubernetes.quarkus.model;

/**
 * @author yu 2021/7/13.
 */
public class MyResponse<T> {

    /**
     * Business status code,the code is 0 when successful
     */
    private int code;

    /**
     * Error message or response message, when successful, message is success
     */
    private String message;

    /**
     * Business data
     */
    private T data;

    public static <T> MyResponse<T> ok() {
        MyResponse<T> myResponse = new MyResponse<T>();
        myResponse.setCode(0);
        myResponse.setMessage("success");
        return myResponse;
    }

    public static <T> MyResponse<T> ok(T t) {
        MyResponse<T> myResponse = new MyResponse<T>();
        myResponse.setCode(0);
        myResponse.setMessage("success");
        myResponse.setData(t);
        return myResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public MyResponse setData(T data) {
        this.data = data;
        return this;
    }
}
