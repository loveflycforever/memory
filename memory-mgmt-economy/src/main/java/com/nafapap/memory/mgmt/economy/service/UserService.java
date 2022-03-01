package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.mgmt.economy.trans.UserBa;

/**
 * <p>Project: memory </p>
 * <p>Name: UserSerivice </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 15:53 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public interface UserService {
    UserBa getUser(String userToken);
}
