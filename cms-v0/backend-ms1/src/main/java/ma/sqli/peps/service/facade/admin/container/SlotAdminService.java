package ma.sqli.peps.service.facade.admin.container;

import java.util.List;
import ma.sqli.peps.bean.core.container.Slot;
import ma.sqli.peps.dao.criteria.core.container.SlotCriteria;
import ma.sqli.peps.zynerator.service.IService;



public interface SlotAdminService extends  IService<Slot,SlotCriteria>  {

    List<Slot> findByTypeId(Long id);
    int deleteByTypeId(Long id);
    long countByTypeCode(String code);
    List<Slot> findByPdpContainerId(Long id);
    int deleteByPdpContainerId(Long id);
    long countByPdpContainerId(Long id);



}
