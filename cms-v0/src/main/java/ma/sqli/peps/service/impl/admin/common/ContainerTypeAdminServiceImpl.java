package ma.sqli.peps.service.impl.admin.common;


import ma.sqli.peps.bean.core.common.ContainerType;
import ma.sqli.peps.dao.criteria.core.common.ContainerTypeCriteria;
import ma.sqli.peps.dao.facade.core.common.ContainerTypeDao;
import ma.sqli.peps.dao.specification.core.common.ContainerTypeSpecification;
import ma.sqli.peps.service.facade.admin.common.ContainerTypeAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import ma.sqli.peps.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ContainerTypeAdminServiceImpl extends AbstractServiceImpl<ContainerType, ContainerTypeCriteria, ContainerTypeDao> implements ContainerTypeAdminService {





    public ContainerType findByReferenceEntity(ContainerType t){
        return  dao.findByCode(t.getCode());
    }


    public List<ContainerType> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ContainerType.class, ContainerTypeSpecification.class);
    }



    public ContainerTypeAdminServiceImpl(ContainerTypeDao dao) {
        super(dao);
    }

}
