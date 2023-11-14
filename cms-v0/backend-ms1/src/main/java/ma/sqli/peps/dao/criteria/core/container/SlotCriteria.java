package  ma.sqli.peps.dao.criteria.core.container;


import ma.sqli.peps.dao.criteria.core.common.SlotTypeCriteria;

import ma.sqli.peps.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SlotCriteria extends  BaseCriteria  {


    private SlotTypeCriteria type ;
    private List<SlotTypeCriteria> types ;
    private PdpContainerCriteria pdpContainer ;
    private List<PdpContainerCriteria> pdpContainers ;


    public SlotCriteria(){}


    public SlotTypeCriteria getType(){
        return this.type;
    }

    public void setType(SlotTypeCriteria type){
        this.type = type;
    }
    public List<SlotTypeCriteria> getTypes(){
        return this.types;
    }

    public void setTypes(List<SlotTypeCriteria> types){
        this.types = types;
    }
    public PdpContainerCriteria getPdpContainer(){
        return this.pdpContainer;
    }

    public void setPdpContainer(PdpContainerCriteria pdpContainer){
        this.pdpContainer = pdpContainer;
    }
    public List<PdpContainerCriteria> getPdpContainers(){
        return this.pdpContainers;
    }

    public void setPdpContainers(List<PdpContainerCriteria> pdpContainers){
        this.pdpContainers = pdpContainers;
    }
}
