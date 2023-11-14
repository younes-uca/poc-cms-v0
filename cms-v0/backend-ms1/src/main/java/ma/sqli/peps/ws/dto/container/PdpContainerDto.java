package  ma.sqli.peps.ws.dto.container;

import ma.sqli.peps.zynerator.audit.Log;
import ma.sqli.peps.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


import ma.sqli.peps.ws.dto.common.ContainerVersionDto;
import ma.sqli.peps.ws.dto.common.ContainerTypeDto;
import ma.sqli.peps.ws.dto.common.ProductTypeDto;
import ma.sqli.peps.ws.dto.common.SlotTypeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PdpContainerDto  extends AuditBaseDto {

    private String productCode  ;
    private String code  ;
    private String buyingFrame  ;
    private Boolean active  ;
    private Boolean hasOnlineVersion  ;
    private Boolean hasSection  ;
    private String label  ;
    private String title  ;
    private String name  ;

    private ProductTypeDto productType ;
    private ContainerTypeDto type ;
    private ContainerVersionDto version ;

    private List<SlotDto> slots ;


    public PdpContainerDto(){
        super();
    }



    @Log
    public String getProductCode(){
        return this.productCode;
    }
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getBuyingFrame(){
        return this.buyingFrame;
    }
    public void setBuyingFrame(String buyingFrame){
        this.buyingFrame = buyingFrame;
    }

    @Log
    public Boolean getActive(){
        return this.active;
    }
    public void setActive(Boolean active){
        this.active = active;
    }

    @Log
    public Boolean getHasOnlineVersion(){
        return this.hasOnlineVersion;
    }
    public void setHasOnlineVersion(Boolean hasOnlineVersion){
        this.hasOnlineVersion = hasOnlineVersion;
    }

    @Log
    public Boolean getHasSection(){
        return this.hasSection;
    }
    public void setHasSection(Boolean hasSection){
        this.hasSection = hasSection;
    }

    @Log
    public String getLabel(){
        return this.label;
    }
    public void setLabel(String label){
        this.label = label;
    }

    @Log
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    @Log
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    public ProductTypeDto getProductType(){
        return this.productType;
    }

    public void setProductType(ProductTypeDto productType){
        this.productType = productType;
    }
    public ContainerTypeDto getType(){
        return this.type;
    }

    public void setType(ContainerTypeDto type){
        this.type = type;
    }
    public ContainerVersionDto getVersion(){
        return this.version;
    }

    public void setVersion(ContainerVersionDto version){
        this.version = version;
    }



    public List<SlotDto> getSlots(){
        return this.slots;
    }

    public void setSlots(List<SlotDto> slots){
        this.slots = slots;
    }



}
