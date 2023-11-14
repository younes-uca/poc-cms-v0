package  ma.sqli.peps.ws.dto.common;

import ma.sqli.peps.zynerator.audit.Log;
import ma.sqli.peps.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTypeDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;




    public ProductTypeDto(){
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
