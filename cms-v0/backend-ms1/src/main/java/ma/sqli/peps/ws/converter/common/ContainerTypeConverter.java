package  ma.sqli.peps.ws.converter.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.sqli.peps.zynerator.util.StringUtil;
import ma.sqli.peps.zynerator.converter.AbstractConverter;
import ma.sqli.peps.zynerator.util.DateUtil;
import ma.sqli.peps.bean.core.common.ContainerType;
import ma.sqli.peps.ws.dto.common.ContainerTypeDto;

@Component
public class ContainerTypeConverter extends AbstractConverter<ContainerType, ContainerTypeDto> {


    public  ContainerTypeConverter(){
        super(ContainerType.class, ContainerTypeDto.class);
    }

    @Override
    public ContainerType toItem(ContainerTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
        ContainerType item = new ContainerType();
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
    public ContainerTypeDto toDto(ContainerType item) {
        if (item == null) {
            return null;
        } else {
            ContainerTypeDto dto = new ContainerTypeDto();
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
