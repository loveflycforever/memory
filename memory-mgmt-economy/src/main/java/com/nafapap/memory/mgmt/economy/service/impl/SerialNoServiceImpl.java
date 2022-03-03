package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import org.springframework.stereotype.Service;

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
    public String generate() {
        return String.valueOf(System.currentTimeMillis());
    }
}
