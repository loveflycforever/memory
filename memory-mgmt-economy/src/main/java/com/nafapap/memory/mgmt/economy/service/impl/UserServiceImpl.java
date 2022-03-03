package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.service.UserService;
import com.nafapap.memory.mgmt.economy.trans.UserBa;
import org.springframework.stereotype.Service;

/**
 * <p>Project: memory </p>
 * <p>Name: UserServiceImpl </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/3/3 16:43 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserBa getUser(String userToken) {
        return new UserBa();
    }
}
