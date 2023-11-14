package ma.sqli.peps.service.impl.admin.container;


import ma.sqli.peps.bean.core.container.Slot;
import ma.sqli.peps.dao.criteria.core.container.SlotCriteria;
import ma.sqli.peps.dao.facade.core.container.SlotDao;
import ma.sqli.peps.dao.specification.core.container.SlotSpecification;
import ma.sqli.peps.service.facade.admin.container.SlotAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import ma.sqli.peps.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.sqli.peps.service.facade.admin.container.PdpContainerAdminService ;
import ma.sqli.peps.bean.core.container.PdpContainer ;
import ma.sqli.peps.service.facade.admin.common.SlotTypeAdminService ;
import ma.sqli.peps.bean.core.common.SlotType ;

import java.util.List;
@Service
public class SlotAdminServiceImpl extends AbstractServiceImpl<Slot, SlotCriteria, SlotDao> implements SlotAdminService {






    public List<Slot> findByTypeId(Long id){
        return dao.findByTypeId(id);
    }
    public int deleteByTypeId(Long id){
        return dao.deleteByTypeId(id);
    }
    public long countByTypeCode(String code){
        return dao.countByTypeCode(code);
    }
    public List<Slot> findByPdpContainerId(Long id){
        return dao.findByPdpContainerId(id);
    }
    public int deleteByPdpContainerId(Long id){
        return dao.deleteByPdpContainerId(id);
    }
    public long countByPdpContainerId(Long id){
        return dao.countByPdpContainerId(id);
    }






    public void configure() {
        super.configure(Slot.class, SlotSpecification.class);
    }


    @Autowired
    private PdpContainerAdminService pdpContainerService ;
    @Autowired
    private SlotTypeAdminService slotTypeService ;

    public SlotAdminServiceImpl(SlotDao dao) {
        super(dao);
    }

}
