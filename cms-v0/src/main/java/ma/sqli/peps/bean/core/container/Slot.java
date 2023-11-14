package ma.sqli.peps.bean.core.container;

import java.util.Objects;





import ma.sqli.peps.bean.core.common.SlotType;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sqli.peps.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "slot")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="slot_seq",sequenceName="slot_seq",allocationSize=1, initialValue = 1)
public class Slot   extends AuditBusinessObject     {

    private Long id;


    private SlotType type ;
    private PdpContainer pdpContainer ;


    public Slot(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="slot_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public SlotType getType(){
        return this.type;
    }
    public void setType(SlotType type){
        this.type = type;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public PdpContainer getPdpContainer(){
        return this.pdpContainer;
    }
    public void setPdpContainer(PdpContainer pdpContainer){
        this.pdpContainer = pdpContainer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return id != null && id.equals(slot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

