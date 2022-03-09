package com.nafapap.memory.support.web;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Project: memory </p>
 * <p>Name: ResponseCodeEnum </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 15:57 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Getter
public class ResponseView {

    private Boolean success;
    private Long retTime;
    private String retCode;
    private String retInfo;
    private Object retData;

    public Long getRetTime() {
        return System.currentTimeMillis();
    }

    public static ResponseView build() {
        ResponseView responseView = new ResponseView();
        responseView.setSuccess(ResponseCode.RP_000000.getSucc());
        responseView.setRetCode(ResponseCode.RP_000000.getCode());
        responseView.setRetInfo(ResponseCode.RP_000000.getDesc());
        return responseView;
    }

    public static ResponseView build(Object data) {
        ResponseView responseView = new ResponseView();
        responseView.setSuccess(ResponseCode.RP_000000.getSucc());
        responseView.setRetCode(ResponseCode.RP_000000.getCode());
        responseView.setRetInfo(ResponseCode.RP_000000.getDesc());
        responseView.setRetData(data);
        return responseView;
    }

    public static ResponseView build(List<?> list) {
        ResponseView responseView = new ResponseView();
        responseView.setSuccess(ResponseCode.RP_000000.getSucc());
        responseView.setRetCode(ResponseCode.RP_000000.getCode());
        responseView.setRetInfo(ResponseCode.RP_000000.getDesc());
        Map<String, Object> map = new HashMap<>(1);
        map.put("list", list);
        responseView.setRetData(map);
        return responseView;
    }

    public static ResponseView build(Exception exception) {
        ResponseView responseView = new ResponseView();
        responseView.setSuccess(ResponseCode.RP_000001.getSucc());
        responseView.setRetCode(ResponseCode.RP_000001.getCode());
        responseView.setRetInfo(exception.getMessage());
        return responseView;
    }

    public static ResponseView build(ResponseCode responseCode) {
        ResponseView responseView = new ResponseView();
        responseView.setSuccess(responseCode.getSucc());
        responseView.setRetCode(responseCode.getCode());
        responseView.setRetInfo(responseCode.getDesc());
        return responseView;
    }

    private ResponseView() {
    }

    private void setSuccess(Boolean success) {
        this.success = success;
    }

    private void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    private void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    private void setRetData(Object retData) {
        this.retData = retData;
    }
}
