package  ma.sqli.peps.ws.converter.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.sqli.peps.zynerator.util.StringUtil;
import ma.sqli.peps.zynerator.converter.AbstractConverter;
import ma.sqli.peps.zynerator.util.DateUtil;
import ma.sqli.peps.bean.core.common.BuyingFrame;
import ma.sqli.peps.ws.dto.common.BuyingFrameDto;

@Component
public class BuyingFrameConverter extends AbstractConverter<BuyingFrame, BuyingFrameDto> {


    public  BuyingFrameConverter(){
        super(BuyingFrame.class, BuyingFrameDto.class);
    }

    @Override
    public BuyingFrame toItem(BuyingFrameDto dto) {
        if (dto == null) {
            return null;
        } else {
        BuyingFrame item = new BuyingFrame();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public BuyingFrameDto toDto(BuyingFrame item) {
        if (item == null) {
            return null;
        } else {
            BuyingFrameDto dto = new BuyingFrameDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
