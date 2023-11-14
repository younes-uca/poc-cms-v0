package  ma.sqli.peps.dao.specification.core.common;

import ma.sqli.peps.zynerator.specification.AbstractSpecification;
import ma.sqli.peps.dao.criteria.core.common.ProductTypeCriteria;
import ma.sqli.peps.bean.core.common.ProductType;


public class ProductTypeSpecification extends  AbstractSpecification<ProductTypeCriteria, ProductType>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ProductTypeSpecification(ProductTypeCriteria criteria) {
        super(criteria);
    }

    public ProductTypeSpecification(ProductTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
