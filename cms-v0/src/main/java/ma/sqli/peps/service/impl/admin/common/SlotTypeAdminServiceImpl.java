package ma.sqli.peps.service.impl.admin.common;


import ma.sqli.peps.bean.core.common.SlotType;
import ma.sqli.peps.dao.criteria.core.common.SlotTypeCriteria;
import ma.sqli.peps.dao.facade.core.common.SlotTypeDao;
import ma.sqli.peps.dao.specification.core.common.SlotTypeSpecification;
import ma.sqli.peps.service.facade.admin.common.SlotTypeAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import ma.sqli.peps.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class SlotTypeAdminServiceImpl extends AbstractServiceImpl<SlotType, SlotTypeCriteria, SlotTypeDao> implements SlotTypeAdminService {





    public SlotType findByReferenceEntity(SlotType t){
        return  dao.findByCode(t.getCode());
    }


    public List<SlotType> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(SlotType.class, SlotTypeSpecification.class);
    }



    public SlotTypeAdminServiceImpl(SlotTypeDao dao) {
        super(dao);
    }

}
