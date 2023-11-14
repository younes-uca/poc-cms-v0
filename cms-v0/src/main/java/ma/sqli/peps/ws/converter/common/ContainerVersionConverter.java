package  ma.sqli.peps.ws.converter.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.sqli.peps.zynerator.util.StringUtil;
import ma.sqli.peps.zynerator.converter.AbstractConverter;
import ma.sqli.peps.zynerator.util.DateUtil;
import ma.sqli.peps.bean.core.common.ContainerVersion;
import ma.sqli.peps.ws.dto.common.ContainerVersionDto;

@Component
public class ContainerVersionConverter extends AbstractConverter<ContainerVersion, ContainerVersionDto> {


    public  ContainerVersionConverter(){
        super(ContainerVersion.class, ContainerVersionDto.class);
    }

    @Override
    public ContainerVersion toItem(ContainerVersionDto dto) {
        if (dto == null) {
            return null;
        } else {
        ContainerVersion item = new ContainerVersion();
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
    public ContainerVersionDto toDto(ContainerVersion item) {
        if (item == null) {
            return null;
        } else {
            ContainerVersionDto dto = new ContainerVersionDto();
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
