package  ma.sqli.peps.ws.converter.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sqli.peps.ws.converter.container.PdpContainerConverter;
import ma.sqli.peps.ws.converter.common.SlotTypeConverter;

import ma.sqli.peps.bean.core.container.PdpContainer;


import ma.sqli.peps.zynerator.util.StringUtil;
import ma.sqli.peps.zynerator.converter.AbstractConverter;
import ma.sqli.peps.zynerator.util.DateUtil;
import ma.sqli.peps.bean.core.container.Slot;
import ma.sqli.peps.ws.dto.container.SlotDto;

@Component
public class SlotConverter extends AbstractConverter<Slot, SlotDto> {

    @Autowired
    private PdpContainerConverter pdpContainerConverter ;
    @Autowired
    private SlotTypeConverter slotTypeConverter ;
    private boolean type;
    private boolean pdpContainer;

    public  SlotConverter(){
        super(Slot.class, SlotDto.class);
    }

    @Override
    public Slot toItem(SlotDto dto) {
        if (dto == null) {
            return null;
        } else {
        Slot item = new Slot();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(this.type && dto.getType()!=null &&  dto.getType().getId() != null)
                item.setType(slotTypeConverter.toItem(dto.getType())) ;

            if(dto.getPdpContainer() != null && dto.getPdpContainer().getId() != null){
                item.setPdpContainer(new PdpContainer());
                item.getPdpContainer().setId(dto.getPdpContainer().getId());
                item.getPdpContainer().setId(dto.getPdpContainer().getId());
            }




        return item;
        }
    }

    @Override
    public SlotDto toDto(Slot item) {
        if (item == null) {
            return null;
        } else {
            SlotDto dto = new SlotDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.type && item.getType()!=null) {
            dto.setType(slotTypeConverter.toDto(item.getType())) ;
        }
        if(this.pdpContainer && item.getPdpContainer()!=null) {
            dto.setPdpContainer(pdpContainerConverter.toDto(item.getPdpContainer())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.type = value;
        this.pdpContainer = value;
    }


    public PdpContainerConverter getPdpContainerConverter(){
        return this.pdpContainerConverter;
    }
    public void setPdpContainerConverter(PdpContainerConverter pdpContainerConverter ){
        this.pdpContainerConverter = pdpContainerConverter;
    }
    public SlotTypeConverter getSlotTypeConverter(){
        return this.slotTypeConverter;
    }
    public void setSlotTypeConverter(SlotTypeConverter slotTypeConverter ){
        this.slotTypeConverter = slotTypeConverter;
    }
    public boolean  isType(){
        return this.type;
    }
    public void  setType(boolean type){
        this.type = type;
    }
    public boolean  isPdpContainer(){
        return this.pdpContainer;
    }
    public void  setPdpContainer(boolean pdpContainer){
        this.pdpContainer = pdpContainer;
    }
}
