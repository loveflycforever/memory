package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.GoodsRepository;
import com.nafapap.memory.mgmt.economy.repository.ProcureRepository;
import com.nafapap.memory.mgmt.economy.service.ProcureService;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.transobj.BelongSerialNo;
import com.nafapap.memory.mgmt.economy.transobj.GoodsVO;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ProcureRequestDto;
import com.nafapap.memory.source.entity.ProcureEntity;
import com.nafapap.memory.support.web.constraints.SerialNo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import static org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT;
import static org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;

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

        String purchaseDatetime = dto.getPurchaseDatetime();
        String closedDate = dto.getClosedDate();

        DateTimeFormatter formatter11 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter12 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateQ = LocalDate.parse(purchaseDatetime, formatter11);
        LocalDate dateW = LocalDate.parse(closedDate, formatter12);
        long actualDay = ChronoUnit.DAYS.between(dateQ, dateW);

        ProcureEntity entity = new ProcureEntity()
                .setSerialNo(serialNoService.generate())
                .setXGoods(symbol)
                .setSummary(dto.getSummary())
                .setPurchaseQuantity(dto.getPurchaseQuantity())
                .setPurchaseSpecific(purchaseSpecific)
                .setPurchaseLocation(dto.getPurchaseLocation())
                .setPurchaseDatetime(purchaseDatetime)
                .setPrice(dto.getPrice())
                .setCurrency(dto.getCurrency())
                .setChinaYuan(dto.getChinaYuan())
                .setHold(hold)
                .setUnit(unit)
                .setPlanDay(dto.getPlanDay())
                .setClosedDate(closedDate)
                .setActualDay(new Long(actualDay).intValue())
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
