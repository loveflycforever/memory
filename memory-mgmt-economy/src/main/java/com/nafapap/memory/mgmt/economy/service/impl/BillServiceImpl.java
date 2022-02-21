package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.commons.enums.Operator;
import com.nafapap.memory.entities.Form;
import com.nafapap.memory.mgmt.economy.data.UserBa;
import com.nafapap.memory.mgmt.economy.repository.FlowMapper;
import com.nafapap.memory.mgmt.economy.service.BillService;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Project: memory </p>
 * <p>Name: BillServiceImpl </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/23 13:40 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
public class BillServiceImpl implements BillService {

    private final UserService userService;
    private final SerialNoService serialNoService;

    private final FlowMapper flowMapper;

    @Autowired
    public BillServiceImpl(UserService userService, SerialNoService serialNoService, FlowMapper flowMapper) {
        this.userService = userService;
        this.serialNoService = serialNoService;
        this.flowMapper = flowMapper;
    }

    @Override
    public Flow createFlow() {
        Flow flow = new Flow();
        flow.setSerialNo(serialNoService.generate());
        //flowMapper
        return null;
    }

    @Override
    public Form createForm(String flowNo) {
        return null;
    }

    @Override
    public void ensure(String takingNo, String operator, String userToken) {
        UserBa user = userService.getUser(userToken);
        user.will(Operator.valueOf(operator)).with(takingNo);


    }
}
