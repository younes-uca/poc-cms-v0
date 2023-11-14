package ma.sqli.peps.requiered.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sqli.peps.zynerator.audit.Log;
import ma.sqli.peps.zynerator.dto.AuditBaseDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuyingFrameDto extends AuditBaseDto {

    private String libelle  ;
    private String code  ;




    public BuyingFrameDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }








}
