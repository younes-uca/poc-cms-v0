package  ma.sqli.peps.dao.specification.core.container;

import ma.sqli.peps.zynerator.specification.AbstractSpecification;
import ma.sqli.peps.dao.criteria.core.container.PdpContainerCriteria;
import ma.sqli.peps.bean.core.container.PdpContainer;


public class PdpContainerSpecification extends  AbstractSpecification<PdpContainerCriteria, PdpContainer>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("productCode", criteria.getProductCode(),criteria.getProductCodeLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("buyingFrame", criteria.getBuyingFrame(),criteria.getBuyingFrameLike());
        addPredicateBool("active", criteria.getActive());
        addPredicateBool("hasOnlineVersion", criteria.getHasOnlineVersion());
        addPredicateBool("hasSection", criteria.getHasSection());
        addPredicate("label", criteria.getLabel(),criteria.getLabelLike());
        addPredicate("title", criteria.getTitle(),criteria.getTitleLike());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicateFk("productType","id", criteria.getProductType()==null?null:criteria.getProductType().getId());
        addPredicateFk("productType","id", criteria.getProductTypes());
        addPredicateFk("productType","code", criteria.getProductType()==null?null:criteria.getProductType().getCode());
        addPredicateFk("type","id", criteria.getType()==null?null:criteria.getType().getId());
        addPredicateFk("type","id", criteria.getTypes());
        addPredicateFk("type","code", criteria.getType()==null?null:criteria.getType().getCode());
        addPredicateFk("version","id", criteria.getVersion()==null?null:criteria.getVersion().getId());
        addPredicateFk("version","id", criteria.getVersions());
        addPredicateFk("version","code", criteria.getVersion()==null?null:criteria.getVersion().getCode());
    }

    public PdpContainerSpecification(PdpContainerCriteria criteria) {
        super(criteria);
    }

    public PdpContainerSpecification(PdpContainerCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
