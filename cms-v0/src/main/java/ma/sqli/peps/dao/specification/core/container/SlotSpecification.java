package  ma.sqli.peps.dao.specification.core.container;

import ma.sqli.peps.zynerator.specification.AbstractSpecification;
import ma.sqli.peps.dao.criteria.core.container.SlotCriteria;
import ma.sqli.peps.bean.core.container.Slot;


public class SlotSpecification extends  AbstractSpecification<SlotCriteria, Slot>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("type","id", criteria.getType()==null?null:criteria.getType().getId());
        addPredicateFk("type","id", criteria.getTypes());
        addPredicateFk("type","code", criteria.getType()==null?null:criteria.getType().getCode());
        addPredicateFk("pdpContainer","id", criteria.getPdpContainer()==null?null:criteria.getPdpContainer().getId());
        addPredicateFk("pdpContainer","id", criteria.getPdpContainers());
    }

    public SlotSpecification(SlotCriteria criteria) {
        super(criteria);
    }

    public SlotSpecification(SlotCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
