package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.mgmt.economy.trans.RequestDto;
import com.nafapap.memory.source.entity.FormEntity;

/**
 * <p>Project: memory </p>
 * <p>Name: FormService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/3/1 16:09 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public interface FormService {
    FormEntity createForm(RequestDto dto);
}
