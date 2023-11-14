package ma.sqli.peps.service.impl.admin.common;


import ma.sqli.peps.bean.core.common.ProductType;
import ma.sqli.peps.dao.criteria.core.common.ProductTypeCriteria;
import ma.sqli.peps.dao.facade.core.common.ProductTypeDao;
import ma.sqli.peps.dao.specification.core.common.ProductTypeSpecification;
import ma.sqli.peps.service.facade.admin.common.ProductTypeAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import ma.sqli.peps.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProductTypeAdminServiceImpl extends AbstractServiceImpl<ProductType, ProductTypeCriteria, ProductTypeDao> implements ProductTypeAdminService {





    public ProductType findByReferenceEntity(ProductType t){
        return  dao.findByCode(t.getCode());
    }


    public List<ProductType> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ProductType.class, ProductTypeSpecification.class);
    }



    public ProductTypeAdminServiceImpl(ProductTypeDao dao) {
        super(dao);
    }

}
