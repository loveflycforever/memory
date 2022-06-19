package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.GoodsRepository;
import com.nafapap.memory.mgmt.economy.repository.ThingRepository;
import com.nafapap.memory.mgmt.economy.service.GoodsService;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.transobj.*;
import com.nafapap.memory.source.entity.GoodsEntity;
import com.nafapap.memory.source.entity.ThingEntity;
import com.nafapap.memory.source.entity.TicketEntity;
import com.nafapap.memory.support.web.constraints.SerialNo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: GoodsService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 21:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
@SerialNo(prefix = "gd")
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final ThingRepository thingRepository;

    private final SerialNoService serialNoService;

    @Override
    public List<GoodsEntity> exhibit(PageDto dto) {
        return goodsRepository.select(dto);
    }

    @Override
    public GoodsEntity create(GoodsRequestDto dto) {
        String belongSerialNo = dto.getBelongSerialNo();
        String symbol = getSymbol(belongSerialNo);

        GoodsEntity entity = new GoodsEntity()
                .setSerialNo(serialNoService.generate())
                .setXThing(symbol)
                .setBrand(dto.getBrand())
                .setName(dto.getName())
                .setSummary(dto.getSummary())
                .setProductionDate(dto.getProductionDate())
                .setValidationTerm(dto.getValidationTerm())
                .setValidationUnit(dto.getValidationUnit())
                .setExpirationDate(dto.getExpirationDate())
                .setBarcode(dto.getBarcode())
                .setUnitPrice(dto.getUnitPrice())
                .setUnitSpec(dto.getUnitSpec());
        goodsRepository.insert(entity);
        return entity;
    }

    private String getSymbol(String belongSerialNo) {
        PageDto pageDto = new PageDto();
        pageDto.setTakingNo(belongSerialNo);

        List<ThingEntity> things = thingRepository.select(pageDto);
        if (CollectionUtils.isEmpty(things) || things.size() != 1) {
            throw new RuntimeException("xxx");
        }

        return things.get(0).getSymbol();
    }
}
