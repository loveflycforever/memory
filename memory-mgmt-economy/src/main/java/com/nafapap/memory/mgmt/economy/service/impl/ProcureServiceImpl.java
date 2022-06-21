package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.GoodsRepository;
import com.nafapap.memory.mgmt.economy.repository.ProcureRepository;
import com.nafapap.memory.mgmt.economy.service.ProcureService;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
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
        String belongSerialNo = dto.getBelongSerialNo();
        String symbol = getSymbol(belongSerialNo);

        ProcureEntity entity = new ProcureEntity()
                .setSerialNo(serialNoService.generate())
                .setXGoods(symbol)
                .setSummary(dto.getSummary())
                .setPurchaseQuantity(dto.getPurchaseQuantity())
                .setPurchaseLocation(dto.getPurchaseLocation())
                .setPurchaseDatetime(dto.getPurchaseDatetime())
                .setPrice(dto.getPrice())
                .setCurrency(dto.getCurrency())
                .setChinaYuan(dto.getChinaYuan())
                .setHold(dto.getHold())
                .setUnit(dto.getUnit())
                .setPlanDay(dto.getPlanDay())
                .setClosedDate(dto.getClosedDate())
                .setActualDay(dto.getActualDay());
        procureRepository.insert(entity);
        return entity;
    }

    private String getSymbol(String belongSerialNo) {
        PageDto pageDto = new PageDto();
        pageDto.setTakingNo(belongSerialNo);

        List<GoodsVO> goodsEntities = goodsRepository.select(pageDto);
        if (CollectionUtils.isEmpty(goodsEntities) || goodsEntities.size() != 1) {
            throw new RuntimeException("xxx");
        }

        return "goods" + goodsEntities.get(0).getId();
    }
}
