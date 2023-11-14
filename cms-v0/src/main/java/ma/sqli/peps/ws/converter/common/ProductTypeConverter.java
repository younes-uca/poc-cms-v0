package  ma.sqli.peps.ws.converter.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.sqli.peps.zynerator.util.StringUtil;
import ma.sqli.peps.zynerator.converter.AbstractConverter;
import ma.sqli.peps.zynerator.util.DateUtil;
import ma.sqli.peps.bean.core.common.ProductType;
import ma.sqli.peps.ws.dto.common.ProductTypeDto;

@Component
public class ProductTypeConverter extends AbstractConverter<ProductType, ProductTypeDto> {


    public  ProductTypeConverter(){
        super(ProductType.class, ProductTypeDto.class);
    }

    @Override
    public ProductType toItem(ProductTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProductType item = new ProductType();
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
    public ProductTypeDto toDto(ProductType item) {
        if (item == null) {
            return null;
        } else {
            ProductTypeDto dto = new ProductTypeDto();
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
