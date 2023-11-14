package ma.sqli.peps.bean.core.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import ma.sqli.peps.zynerator.audit.AuditBusinessObject;

import java.util.Objects;


@Entity
@Table(name = "buying_frame")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name = "buying_frame_seq", sequenceName = "buying_frame_seq", allocationSize = 1, initialValue = 1)
public class BuyingFrame extends AuditBusinessObject {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;


    public BuyingFrame() {
        super();
    }

    public BuyingFrame(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public BuyingFrame(String libelle) {
        this.libelle = libelle;
    }


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buying_frame_seq")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
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
        BuyingFrame buyingFrame = (BuyingFrame) o;
        return id != null && id.equals(buyingFrame.id);
    }

    @Override
    public String toString() {
        return "BuyingFrame{" + "id=" + id + ", libelle='" + libelle + '\'' + ", code='" + code + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

