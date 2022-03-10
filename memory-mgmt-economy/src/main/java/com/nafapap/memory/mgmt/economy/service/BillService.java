package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.FormEntity;

import java.util.List;

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

    FormEntity createForm(RequestDto dto);

    void ensure(String takingNo, String operator, String userToken);

    List<FormEntity> showForm(PageDto dto);

    void join(String formNo, String flowNo);

}
