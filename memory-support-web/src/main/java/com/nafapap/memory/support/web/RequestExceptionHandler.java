package com.nafapap.memory.support.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class RequestExceptionHandler {

    /**
     * post请求参数校验时抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseView methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return errorMsgHandler(e.getBindingResult().getAllErrors());
    }

    /**
     * get请求参数校验时抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseView bindExceptionHandler(BindException e) {
        return errorMsgHandler(e.getBindingResult().getAllErrors());
    }

    /**
     * 请求方法中校验抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseView constraintViolationExceptionHandler(ConstraintViolationException e) {
        //获取异常中第一个错误信息
        String errorMsg = e.getConstraintViolations().iterator().next().getMessage();
        log.error(ResponseCode.RP_000001.getDesc() + "," + errorMsg);
        return ResponseView.build(new Exception(errorMsg));
    }

    /**
     * 请求方法中校验抛出的异常
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseView businessExceptionHandler(ServiceException e) {
        //获取异常中第一个错误信息
        String errorMsg = e.getMessage();
        log.error(ResponseCode.RP_000001.getDesc() + "," + errorMsg);
        return ResponseView.build(new Exception(errorMsg));
    }

    /**
     * 处理errorList描述
     *
     * @param objectErrorList
     * @return
     */
    private ResponseView errorMsgHandler(List<ObjectError> objectErrorList) {
        StringBuilder sb = new StringBuilder();
        if (!CollectionUtils.isEmpty(objectErrorList)) {
            for (ObjectError objectError : objectErrorList) {
                sb.append(objectError.getDefaultMessage()).append(";");
            }
        }
        log.error(ResponseCode.RP_000002.getDesc() + "," + sb.toString());
        return ResponseView.build(new Exception(sb.toString()));
    }


    /**
     * npe异常处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ResponseView globalException(NullPointerException ex) {
        log.error("系统捕获异常:", ex);
        return ResponseView.build(new Exception(ResponseCode.RP_000001.getDesc()));
    }


}
