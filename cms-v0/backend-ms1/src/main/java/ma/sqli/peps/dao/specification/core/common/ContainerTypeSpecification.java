package  ma.sqli.peps.dao.specification.core.common;

import ma.sqli.peps.zynerator.specification.AbstractSpecification;
import ma.sqli.peps.dao.criteria.core.common.ContainerTypeCriteria;
import ma.sqli.peps.bean.core.common.ContainerType;


public class ContainerTypeSpecification extends  AbstractSpecification<ContainerTypeCriteria, ContainerType>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ContainerTypeSpecification(ContainerTypeCriteria criteria) {
        super(criteria);
    }

    public ContainerTypeSpecification(ContainerTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
