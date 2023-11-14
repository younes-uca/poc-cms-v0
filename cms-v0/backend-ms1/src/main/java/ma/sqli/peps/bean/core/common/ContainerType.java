package ma.sqli.peps.bean.core.common;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sqli.peps.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "container_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="container_type_seq",sequenceName="container_type_seq",allocationSize=1, initialValue = 1)
public class ContainerType   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;



    public ContainerType(){
        super();
    }

    public ContainerType(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public ContainerType(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="container_type_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerType containerType = (ContainerType) o;
        return id != null && id.equals(containerType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

