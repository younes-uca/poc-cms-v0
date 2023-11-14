package ma.sqli.peps.service.impl.admin.common;


import ma.sqli.peps.bean.core.common.ContainerVersion;
import ma.sqli.peps.dao.criteria.core.common.ContainerVersionCriteria;
import ma.sqli.peps.dao.facade.core.common.ContainerVersionDao;
import ma.sqli.peps.dao.specification.core.common.ContainerVersionSpecification;
import ma.sqli.peps.service.facade.admin.common.ContainerVersionAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import ma.sqli.peps.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ContainerVersionAdminServiceImpl extends AbstractServiceImpl<ContainerVersion, ContainerVersionCriteria, ContainerVersionDao> implements ContainerVersionAdminService {





    public ContainerVersion findByReferenceEntity(ContainerVersion t){
        return  dao.findByCode(t.getCode());
    }


    public List<ContainerVersion> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ContainerVersion.class, ContainerVersionSpecification.class);
    }



    public ContainerVersionAdminServiceImpl(ContainerVersionDao dao) {
        super(dao);
    }

}
