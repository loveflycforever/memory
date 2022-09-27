package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.ThingRepository;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.service.ThingService;
import com.nafapap.memory.mgmt.economy.transobj.ThingPageDto;
import com.nafapap.memory.mgmt.economy.transobj.ThingRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.ThingVO;
import com.nafapap.memory.source.entity.ThingEntity;
import com.nafapap.memory.support.web.constraints.SerialNo;
import lombok.RequiredArgsConstructor;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ThingService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 21:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
@SerialNo(prefix = "tg")
public class ThingServiceImpl implements ThingService {

    private final ThingRepository thingRepository;

    private final SerialNoService serialNoService;

    @Override
    public List<ThingVO> exhibit(ThingPageDto dto) {
        return thingRepository.select(dto);
    }

    @Override
    public ThingEntity create(ThingRequestDto dto) {
        if (StringUtils.isBlank(dto.getSymbol())) {
            dto.setSymbol(getAllSpell(dto.getName()));
        }

        if (StringUtils.isBlank(dto.getSummary())) {
            dto.setSummary("这是" + dto.getName() + "。");
        }
        ThingEntity entity = new ThingEntity()
                .setSerialNo(serialNoService.generate())
                .setName(dto.getName())
                .setSummary(dto.getSummary())
                .setSymbol(dto.getSymbol());
        thingRepository.insert(entity);
        return entity;
    }

    public static String getAllSpell(String chinese) {
        StringBuilder buffer = new StringBuilder();
        HanyuPinyinOutputFormat formart = new HanyuPinyinOutputFormat();
        formart.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        formart.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        formart.setVCharType(HanyuPinyinVCharType.WITH_V);
        char[] array = chinese.trim().toCharArray();
        try {
            for (char t : array) {
                // 匹配是否是中文
                if (Character.toString(t).matches("[\\u4e00-\\u9fa5]")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(t, formart);
                    String str = StringUtils.capitalize(temp[0]);
                    buffer.append(str);
                } else {
                    buffer.append(t);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return buffer.toString().replaceAll("\\W", "").trim();
    }

}
