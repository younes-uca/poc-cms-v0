package  ma.sqli.peps.ws.dto.container;

import ma.sqli.peps.zynerator.audit.Log;
import ma.sqli.peps.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.sqli.peps.ws.dto.common.SlotTypeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlotDto  extends AuditBaseDto {


    private SlotTypeDto type ;
    private PdpContainerDto pdpContainer ;



    public SlotDto(){
        super();
    }




    public SlotTypeDto getType(){
        return this.type;
    }

    public void setType(SlotTypeDto type){
        this.type = type;
    }
    public PdpContainerDto getPdpContainer(){
        return this.pdpContainer;
    }

    public void setPdpContainer(PdpContainerDto pdpContainer){
        this.pdpContainer = pdpContainer;
    }






}
