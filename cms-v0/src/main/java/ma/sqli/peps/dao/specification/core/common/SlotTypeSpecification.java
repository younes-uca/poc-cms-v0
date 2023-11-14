package  ma.sqli.peps.dao.specification.core.common;

import ma.sqli.peps.zynerator.specification.AbstractSpecification;
import ma.sqli.peps.dao.criteria.core.common.SlotTypeCriteria;
import ma.sqli.peps.bean.core.common.SlotType;


public class SlotTypeSpecification extends  AbstractSpecification<SlotTypeCriteria, SlotType>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public SlotTypeSpecification(SlotTypeCriteria criteria) {
        super(criteria);
    }

    public SlotTypeSpecification(SlotTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
