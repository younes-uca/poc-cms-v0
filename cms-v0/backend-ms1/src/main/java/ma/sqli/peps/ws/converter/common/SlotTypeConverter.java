package  ma.sqli.peps.ws.converter.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.sqli.peps.zynerator.util.StringUtil;
import ma.sqli.peps.zynerator.converter.AbstractConverter;
import ma.sqli.peps.zynerator.util.DateUtil;
import ma.sqli.peps.bean.core.common.SlotType;
import ma.sqli.peps.ws.dto.common.SlotTypeDto;

@Component
public class SlotTypeConverter extends AbstractConverter<SlotType, SlotTypeDto> {


    public  SlotTypeConverter(){
        super(SlotType.class, SlotTypeDto.class);
    }

    @Override
    public SlotType toItem(SlotTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
        SlotType item = new SlotType();
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
    public SlotTypeDto toDto(SlotType item) {
        if (item == null) {
            return null;
        } else {
            SlotTypeDto dto = new SlotTypeDto();
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
