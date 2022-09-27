package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.GoodsRepository;
import com.nafapap.memory.mgmt.economy.repository.ThingRepository;
import com.nafapap.memory.mgmt.economy.service.GoodsService;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.service.observer.MeListener;
import com.nafapap.memory.mgmt.economy.service.observer.MemoryEvent;
import com.nafapap.memory.mgmt.economy.service.observer.MemoryEventListener;
import com.nafapap.memory.mgmt.economy.transobj.*;
import com.nafapap.memory.source.entity.GoodsEntity;
import com.nafapap.memory.support.web.constraints.SerialNo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

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
@MeListener(publisher = TicketServiceImpl.class)
public class GoodsServiceImpl implements GoodsService, MemoryEventListener {

    private final GoodsRepository goodsRepository;
    private final ThingRepository thingRepository;

    private final SerialNoService serialNoService;

    @Override
    public List<GoodsVO> exhibit(PageDto dto) {
        return goodsRepository.select(dto, GoodsVO.class);
    }

    @Override
    public GoodsVO create(GoodsRequestDto dto) {
        //BelongSerialNo belongSerialNo = dto.getBelongSerialNo();

        GoodsEntity entity = convert2Entity(dto);


        NameString thingName = dto.getThingName();
        String symbol = getSymbol(thingName);
        entity.setXThing(symbol);


        entity.setSerialNo(serialNoService.generate());
        goodsRepository.insert(entity);
        return goodsRepository.toVO(entity, GoodsVO.class);
    }

    private GoodsEntity convert2Entity(GoodsRequestDto dto) {
        return new GoodsEntity()
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
    }

    @Override
    public GoodsVO prepare(GoodsRequestDto goodsRequestDto) {
        return null;
    }

    @Override
    public GoodsVO confirm(GoodsRequestDto goodsRequestDto) {
        return null;
    }

    @Override
    public GoodsVO cancel(GoodsRequestDto dto) {
        return null;
    }

    private String getSymbol(BelongSerialNo belongSerialNo) {
        ThingPageDto pageDto = new ThingPageDto();
        pageDto.setTakingNo(belongSerialNo.getValue());
        pageDto.onlyOne();

        List<ThingVO> things = thingRepository.select(pageDto);
        if (CollectionUtils.isEmpty(things)) {
            throw new RuntimeException("xxx");
        }

        return things.get(0).getSymbol();
    }

    private String getSymbol(NameString nameString) {
        ThingPageDto pageDto = new ThingPageDto();
        pageDto.setName(nameString.getValue());
        pageDto.onlyOne();

        List<ThingVO> things = thingRepository.select(pageDto);
        if (CollectionUtils.isEmpty(things)) {
            throw new RuntimeException("xxx");
        }

        return things.get(0).getSymbol();
    }

    @Override
    public <E extends MemoryEvent> void onMethodBegin(E event) {

    }

    @Override
    public <E extends MemoryEvent> void onMethodEnd(E event) {

    }

    @Override
    public <E extends MemoryEvent> void doSomething(E event) {

    }
}
