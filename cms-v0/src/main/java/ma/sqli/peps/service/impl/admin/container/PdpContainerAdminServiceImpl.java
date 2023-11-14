package ma.sqli.peps.service.impl.admin.container;


import ma.sqli.peps.bean.core.container.PdpContainer;
import ma.sqli.peps.dao.criteria.core.container.PdpContainerCriteria;
import ma.sqli.peps.dao.facade.core.container.PdpContainerDao;
import ma.sqli.peps.dao.specification.core.container.PdpContainerSpecification;
import ma.sqli.peps.service.facade.admin.container.PdpContainerAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import ma.sqli.peps.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sqli.peps.service.facade.admin.common.ContainerVersionAdminService ;
import ma.sqli.peps.bean.core.common.ContainerVersion ;
import ma.sqli.peps.service.facade.admin.common.ContainerTypeAdminService ;
import ma.sqli.peps.bean.core.common.ContainerType ;
import ma.sqli.peps.service.facade.admin.container.SlotAdminService ;
import ma.sqli.peps.bean.core.container.Slot ;
import ma.sqli.peps.service.facade.admin.common.ProductTypeAdminService ;
import ma.sqli.peps.bean.core.common.ProductType ;

import java.util.List;
@Service
public class PdpContainerAdminServiceImpl extends AbstractServiceImpl<PdpContainer, PdpContainerCriteria, PdpContainerDao> implements PdpContainerAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public PdpContainer create(PdpContainer t) {
    super.create(t);
        if (t.getSlots() != null) {
                t.getSlots().forEach(element-> {
                    element.setPdpContainer(t);
                    slotService.create(element);
            });
        }
        return t;

    }

    public PdpContainer findWithAssociatedLists(Long id){
        PdpContainer result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSlots(slotService.findByPdpContainerId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        slotService.deleteByPdpContainerId(id);
    }


    public void updateWithAssociatedLists(PdpContainer pdpContainer){
    if(pdpContainer !=null && pdpContainer.getId() != null){
            List<List<Slot>> resultSlots= slotService.getToBeSavedAndToBeDeleted(slotService.findByPdpContainerId(pdpContainer.getId()),pdpContainer.getSlots());
            slotService.delete(resultSlots.get(1));
            ListUtil.emptyIfNull(resultSlots.get(0)).forEach(e -> e.setPdpContainer(pdpContainer));
            slotService.update(resultSlots.get(0),true);
    }
    }




    public List<PdpContainer> findByTypeId(Long id){
        return dao.findByTypeId(id);
    }
    public int deleteByTypeId(Long id){
        return dao.deleteByTypeId(id);
    }
    public long countByTypeCode(String code){
        return dao.countByTypeCode(code);
    }
    public List<PdpContainer> findByVersionId(Long id){
        return dao.findByVersionId(id);
    }
    public int deleteByVersionId(Long id){
        return dao.deleteByVersionId(id);
    }
    public long countByVersionCode(String code){
        return dao.countByVersionCode(code);
    }






    public void configure() {
        super.configure(PdpContainer.class, PdpContainerSpecification.class);
    }


    @Autowired
    private ContainerVersionAdminService containerVersionService ;
    @Autowired
    private ContainerTypeAdminService containerTypeService ;
    @Autowired
    private SlotAdminService slotService ;
    @Autowired
    private ProductTypeAdminService productTypeService ;

    public PdpContainerAdminServiceImpl(PdpContainerDao dao) {
        super(dao);
    }

}
