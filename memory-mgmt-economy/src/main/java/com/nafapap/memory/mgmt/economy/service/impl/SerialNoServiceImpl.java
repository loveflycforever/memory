package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.support.web.constraints.SerialNo;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>Project: memory </p>
 * <p>Name: SerialNoServiceIMpl </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/3/3 16:36 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
public class SerialNoServiceImpl implements SerialNoService {

    @Override
    public synchronized String generate() {
        String result = DateFormatUtils.format(new Date(), "yyyyMMddHHmmsss");

        String callerClassName = new Exception().getStackTrace()[1].getClassName();
        try {
            Class<?> callerClass = Class.forName(callerClassName);

            if (callerClass.isAnnotationPresent(SerialNo.class)) {
                String prefix = callerClass.getAnnotation(SerialNo.class).prefix();
                result = prefix + result;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }


}
