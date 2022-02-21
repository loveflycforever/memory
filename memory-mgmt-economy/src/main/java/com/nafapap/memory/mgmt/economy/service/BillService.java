package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.entities.Form;
import com.nafapap.memory.entities.entity.FlowEntity;

/**
 * <p>Project: memory </p>
 * <p>Name: BillService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/23 13:39 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public interface BillService {
    FlowEntity createFlow();

    Form createForm(String flowNo);

    void ensure(String takingNo, String operator, String userToken);
}
