package ma.sqli.peps.service.impl.admin.common;


import ma.sqli.peps.bean.core.common.BuyingFrame;
import ma.sqli.peps.dao.criteria.core.common.BuyingFrameCriteria;
import ma.sqli.peps.dao.facade.core.common.BuyingFrameDao;
import ma.sqli.peps.dao.specification.core.common.BuyingFrameSpecification;
import ma.sqli.peps.service.facade.admin.common.BuyingFrameAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import ma.sqli.peps.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class BuyingFrameAdminServiceImpl extends AbstractServiceImpl<BuyingFrame, BuyingFrameCriteria, BuyingFrameDao> implements BuyingFrameAdminService {





    public BuyingFrame findByReferenceEntity(BuyingFrame t){
        return  dao.findByCode(t.getCode());
    }


    public List<BuyingFrame> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(BuyingFrame.class, BuyingFrameSpecification.class);
    }



    public BuyingFrameAdminServiceImpl(BuyingFrameDao dao) {
        super(dao);
    }

}
