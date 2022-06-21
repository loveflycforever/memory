package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.GoodsRepository;
import com.nafapap.memory.mgmt.economy.repository.ProcureRepository;
import com.nafapap.memory.mgmt.economy.service.ProcureService;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.transobj.BelongSerialNo;
import com.nafapap.memory.mgmt.economy.transobj.GoodsVO;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ProcureRequestDto;
import com.nafapap.memory.source.entity.GoodsEntity;
import com.nafapap.memory.source.entity.ProcureEntity;
import com.nafapap.memory.source.entity.ThingEntity;
import com.nafapap.memory.support.web.constraints.SerialNo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ProcureService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 21:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
@SerialNo(prefix = "pc")
public class ProcureServiceImpl implements ProcureService {

    private final ProcureRepository procureRepository;
    private final GoodsRepository goodsRepository;

    private final SerialNoService serialNoService;

    @Override
    public List<ProcureEntity> exhibit(PageDto dto) {
        return procureRepository.select(dto);
    }

    @Override
    public ProcureEntity create(ProcureRequestDto dto) {
        BelongSerialNo belongSerialNo = dto.getBelongSerialNo();
        String symbol = getSymbol(belongSerialNo);
        GoodsVO goods = getGoods(belongSerialNo);
        if (dto.getPrice() == null) {
            BigDecimal unitPrice = goods.getUnitPrice();
            BigDecimal purchaseQuantity = dto.getPurchaseQuantity();
            dto.setPrice(unitPrice.multiply(purchaseQuantity));
        }

        if (dto.getChinaYuan() == null) {
            dto.setChinaYuan(dto.getPrice());
        }

        String unitSpec = goods.getUnitSpec();
        String[] split = unitSpec.split("/");
        String front = split[0];
        String[] frontSplit = front.split(" ");
        String frontFirst = frontSplit[0];
        String frontEnd = frontSplit[1];
        String back = split[1];

        BigDecimal hold = dto.getPurchaseQuantity().multiply(new BigDecimal(frontFirst));
        String unit = frontEnd;

        String purchaseSpecific = back;

        ProcureEntity entity = new ProcureEntity()
                .setSerialNo(serialNoService.generate())
                .setXGoods(symbol)
                .setSummary(dto.getSummary())
                .setPurchaseQuantity(dto.getPurchaseQuantity())
                .setPurchaseSpecific(purchaseSpecific)
                .setPurchaseLocation(dto.getPurchaseLocation())
                .setPurchaseDatetime(dto.getPurchaseDatetime())
                .setPrice(dto.getPrice())
                .setCurrency(dto.getCurrency())
                .setChinaYuan(dto.getChinaYuan())
                .setHold(hold)
                .setUnit(unit)
                .setPlanDay(dto.getPlanDay())
                .setClosedDate(dto.getClosedDate())
                .setActualDay(dto.getActualDay())
                ;
        procureRepository.insert(entity);
        return entity;
    }

    private String getSymbol(BelongSerialNo belongSerialNo) {
        PageDto pageDto = new PageDto();
        pageDto.setTakingNo(belongSerialNo.getValue());
        pageDto.onlyOne();

        List<GoodsVO> goodsEntities = goodsRepository.select(pageDto);
        if (CollectionUtils.isEmpty(goodsEntities)) {
            throw new RuntimeException("xxx");
        }

        return "goods" + goodsEntities.get(0).getId();
    }

    private GoodsVO getGoods(BelongSerialNo belongSerialNo) {
        PageDto pageDto = new PageDto();
        pageDto.setTakingNo(belongSerialNo.getValue());
        pageDto.onlyOne();

        List<GoodsVO> goodsEntities = goodsRepository.select(pageDto);
        if (CollectionUtils.isEmpty(goodsEntities)) {
            throw new RuntimeException("xxx");
        }

        return goodsEntities.get(0);
    }
}
