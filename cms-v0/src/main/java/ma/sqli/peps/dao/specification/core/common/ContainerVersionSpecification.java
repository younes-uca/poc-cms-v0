package  ma.sqli.peps.dao.specification.core.common;

import ma.sqli.peps.zynerator.specification.AbstractSpecification;
import ma.sqli.peps.dao.criteria.core.common.ContainerVersionCriteria;
import ma.sqli.peps.bean.core.common.ContainerVersion;


public class ContainerVersionSpecification extends  AbstractSpecification<ContainerVersionCriteria, ContainerVersion>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ContainerVersionSpecification(ContainerVersionCriteria criteria) {
        super(criteria);
    }

    public ContainerVersionSpecification(ContainerVersionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
