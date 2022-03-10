package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.commons.enums.Operator;
import com.nafapap.memory.mgmt.economy.repository.BillRepository;
import com.nafapap.memory.mgmt.economy.service.BillService;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.service.UserService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.mgmt.economy.transobj.UserBa;
import com.nafapap.memory.source.entity.FormEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final UserService userService;
    private final SerialNoService serialNoService;

    private final BillRepository billRepository;

    @Override
    public void ensure(String takingNo, String operator, String userToken) {
        UserBa user = userService.getUser(userToken);
        user.will(Operator.valueOf(operator)).with(takingNo);
    }

    @Override
    public FormEntity createForm(RequestDto dto) {
        FormEntity entity = new FormEntity()
                .setFormat(dto.getFormat())
                .setSerialNo(serialNoService.generate());
        Long id = billRepository.insertForm(entity);
        entity.setId(id);
        return entity;
    }

    @Override
    public List<FormEntity> showForm(PageDto dto) {
        return billRepository.selectForms(dto);
    }

    @Override
    public void join(String formNo, String flowNo) {
        FormEntity flowEntity = billRepository.selectFormBySerialNo(flowNo);
        FormEntity formEntity = billRepository.selectFormBySerialNo(formNo);

        FormEntity update = new FormEntity().setId(formEntity.getId())
                .setFlowNo(flowEntity.getSerialNo())
                .setVersion(formEntity.getVersion());
        billRepository.update(update);
    }
}
