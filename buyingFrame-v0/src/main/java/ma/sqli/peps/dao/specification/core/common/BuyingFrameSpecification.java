package  ma.sqli.peps.dao.specification.core.common;

import ma.sqli.peps.zynerator.specification.AbstractSpecification;
import ma.sqli.peps.dao.criteria.core.common.BuyingFrameCriteria;
import ma.sqli.peps.bean.core.common.BuyingFrame;


public class BuyingFrameSpecification extends  AbstractSpecification<BuyingFrameCriteria, BuyingFrame>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public BuyingFrameSpecification(BuyingFrameCriteria criteria) {
        super(criteria);
    }

    public BuyingFrameSpecification(BuyingFrameCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
