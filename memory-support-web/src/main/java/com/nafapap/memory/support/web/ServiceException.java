package com.nafapap.memory.support.web;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 675054400927446700L;
    protected String code;
    protected String msg;

    public ServiceException() {
    }

    public ServiceException(String msg) {
        this(ResponseCode.RP_000001.getCode(), msg);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String msg, Exception e) {
        super(msg, e);
    }

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
