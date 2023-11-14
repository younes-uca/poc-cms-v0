package  ma.sqli.peps.ws.converter.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sqli.peps.zynerator.util.ListUtil;

import ma.sqli.peps.ws.converter.common.ContainerVersionConverter;
import ma.sqli.peps.ws.converter.common.ContainerTypeConverter;
import ma.sqli.peps.ws.converter.container.SlotConverter;
import ma.sqli.peps.ws.converter.common.ProductTypeConverter;
import ma.sqli.peps.ws.converter.common.SlotTypeConverter;



import ma.sqli.peps.zynerator.util.StringUtil;
import ma.sqli.peps.zynerator.converter.AbstractConverter;
import ma.sqli.peps.zynerator.util.DateUtil;
import ma.sqli.peps.bean.core.container.PdpContainer;
import ma.sqli.peps.ws.dto.container.PdpContainerDto;

@Component
public class PdpContainerConverter extends AbstractConverter<PdpContainer, PdpContainerDto> {

    @Autowired
    private ContainerVersionConverter containerVersionConverter ;
    @Autowired
    private ContainerTypeConverter containerTypeConverter ;
    @Autowired
    private SlotConverter slotConverter ;
    @Autowired
    private ProductTypeConverter productTypeConverter ;
    @Autowired
    private SlotTypeConverter slotTypeConverter ;
    private boolean productType;
    private boolean type;
    private boolean version;
    private boolean slots;

    public  PdpContainerConverter(){
        super(PdpContainer.class, PdpContainerDto.class);
        init(true);
    }

    @Override
    public PdpContainer toItem(PdpContainerDto dto) {
        if (dto == null) {
            return null;
        } else {
        PdpContainer item = new PdpContainer();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getProductCode()))
                item.setProductCode(dto.getProductCode());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getBuyingFrame()))
                item.setBuyingFrame(dto.getBuyingFrame());
            if(dto.getActive() != null)
                item.setActive(dto.getActive());
            if(dto.getHasOnlineVersion() != null)
                item.setHasOnlineVersion(dto.getHasOnlineVersion());
            if(dto.getHasSection() != null)
                item.setHasSection(dto.getHasSection());
            if(StringUtil.isNotEmpty(dto.getLabel()))
                item.setLabel(dto.getLabel());
            if(StringUtil.isNotEmpty(dto.getTitle()))
                item.setTitle(dto.getTitle());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(this.productType && dto.getProductType()!=null &&  dto.getProductType().getId() != null)
                item.setProductType(productTypeConverter.toItem(dto.getProductType())) ;

            if(this.type && dto.getType()!=null &&  dto.getType().getId() != null)
                item.setType(containerTypeConverter.toItem(dto.getType())) ;

            if(this.version && dto.getVersion()!=null &&  dto.getVersion().getId() != null)
                item.setVersion(containerVersionConverter.toItem(dto.getVersion())) ;


            if(this.slots && ListUtil.isNotEmpty(dto.getSlots()))
                item.setSlots(slotConverter.toItem(dto.getSlots()));


        return item;
        }
    }

    @Override
    public PdpContainerDto toDto(PdpContainer item) {
        if (item == null) {
            return null;
        } else {
            PdpContainerDto dto = new PdpContainerDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getProductCode()))
                dto.setProductCode(item.getProductCode());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getBuyingFrame()))
                dto.setBuyingFrame(item.getBuyingFrame());
                dto.setActive(item.getActive());
                dto.setHasOnlineVersion(item.getHasOnlineVersion());
                dto.setHasSection(item.getHasSection());
            if(StringUtil.isNotEmpty(item.getLabel()))
                dto.setLabel(item.getLabel());
            if(StringUtil.isNotEmpty(item.getTitle()))
                dto.setTitle(item.getTitle());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
        if(this.productType && item.getProductType()!=null) {
            dto.setProductType(productTypeConverter.toDto(item.getProductType())) ;
        }
        if(this.type && item.getType()!=null) {
            dto.setType(containerTypeConverter.toDto(item.getType())) ;
        }
        if(this.version && item.getVersion()!=null) {
            dto.setVersion(containerVersionConverter.toDto(item.getVersion())) ;
        }
        if(this.slots && ListUtil.isNotEmpty(item.getSlots())){
            slotConverter.init(true);
            slotConverter.setPdpContainer(false);
            dto.setSlots(slotConverter.toDto(item.getSlots()));
            slotConverter.setPdpContainer(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.slots = value;
    }

    public void initObject(boolean value) {
        this.productType = value;
        this.type = value;
        this.version = value;
    }


    public ContainerVersionConverter getContainerVersionConverter(){
        return this.containerVersionConverter;
    }
    public void setContainerVersionConverter(ContainerVersionConverter containerVersionConverter ){
        this.containerVersionConverter = containerVersionConverter;
    }
    public ContainerTypeConverter getContainerTypeConverter(){
        return this.containerTypeConverter;
    }
    public void setContainerTypeConverter(ContainerTypeConverter containerTypeConverter ){
        this.containerTypeConverter = containerTypeConverter;
    }
    public SlotConverter getSlotConverter(){
        return this.slotConverter;
    }
    public void setSlotConverter(SlotConverter slotConverter ){
        this.slotConverter = slotConverter;
    }
    public ProductTypeConverter getProductTypeConverter(){
        return this.productTypeConverter;
    }
    public void setProductTypeConverter(ProductTypeConverter productTypeConverter ){
        this.productTypeConverter = productTypeConverter;
    }
    public SlotTypeConverter getSlotTypeConverter(){
        return this.slotTypeConverter;
    }
    public void setSlotTypeConverter(SlotTypeConverter slotTypeConverter ){
        this.slotTypeConverter = slotTypeConverter;
    }
    public boolean  isProductType(){
        return this.productType;
    }
    public void  setProductType(boolean productType){
        this.productType = productType;
    }
    public boolean  isType(){
        return this.type;
    }
    public void  setType(boolean type){
        this.type = type;
    }
    public boolean  isVersion(){
        return this.version;
    }
    public void  setVersion(boolean version){
        this.version = version;
    }
    public boolean  isSlots(){
        return this.slots ;
    }
    public void  setSlots(boolean slots ){
        this.slots  = slots ;
    }
}
