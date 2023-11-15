package ma.sqli.peps.bean.core.container;

import java.util.Objects;
import java.util.List;





import ma.sqli.peps.bean.core.common.ContainerVersion;
import ma.sqli.peps.bean.core.common.ContainerType;
import ma.sqli.peps.bean.core.common.ProductType;
import ma.sqli.peps.bean.core.common.SlotType;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sqli.peps.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "pdp_container")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="pdp_container_seq",sequenceName="pdp_container_seq",allocationSize=1, initialValue = 1)
public class PdpContainer   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String productCode;
    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String buyingFrame;
    @Column(columnDefinition = "boolean default false")
    private Boolean active = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean hasOnlineVersion = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean hasSection = false;
    @Column(length = 500)
    private String label;
    @Column(length = 500)
    private String title;
    @Column(length = 500)
    private String name;

    private ProductType productType ;
    private ContainerType type ;
    private ContainerVersion version ;

    private List<Slot> slots ;

    public PdpContainer(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="pdp_container_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ProductType getProductType(){
        return this.productType;
    }
    public void setProductType(ProductType productType){
        this.productType = productType;
    }
    public String getProductCode(){
        return this.productCode;
    }
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getBuyingFrame(){
        return this.buyingFrame;
    }
    public void setBuyingFrame(String buyingFrame){
        this.buyingFrame = buyingFrame;
    }
    public Boolean  getActive(){
        return this.active;
    }
    public void setActive(Boolean active){
        this.active = active;
    }
    public Boolean  getHasOnlineVersion(){
        return this.hasOnlineVersion;
    }
    public void setHasOnlineVersion(Boolean hasOnlineVersion){
        this.hasOnlineVersion = hasOnlineVersion;
    }
    public Boolean  getHasSection(){
        return this.hasSection;
    }
    public void setHasSection(Boolean hasSection){
        this.hasSection = hasSection;
    }
    public String getLabel(){
        return this.label;
    }
    public void setLabel(String label){
        this.label = label;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ContainerType getType(){
        return this.type;
    }
    public void setType(ContainerType type){
        this.type = type;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ContainerVersion getVersion(){
        return this.version;
    }
    public void setVersion(ContainerVersion version){
        this.version = version;
    }
    @OneToMany(mappedBy = "pdpContainer")

    public List<Slot> getSlots(){
        return this.slots;
    }
    public void setSlots(List<Slot> slots){
        this.slots = slots;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdpContainer pdpContainer = (PdpContainer) o;
        return id != null && id.equals(pdpContainer.id);
    }

    @Override
    public String toString() {
        return "PdpContainer{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", code='" + code + '\'' +
                ", buyingFrame='" + buyingFrame + '\'' +
                ", active=" + active +
                ", hasOnlineVersion=" + hasOnlineVersion +
                ", hasSection=" + hasSection +
                ", label='" + label + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                ", type=" + type +
                ", version=" + version +
                ", slots=" + slots +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

