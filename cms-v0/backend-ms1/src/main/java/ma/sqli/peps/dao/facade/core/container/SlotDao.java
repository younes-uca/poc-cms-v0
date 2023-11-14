package ma.sqli.peps.dao.facade.core.container;

import ma.sqli.peps.zynerator.repository.AbstractRepository;
import ma.sqli.peps.bean.core.container.Slot;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SlotDao extends AbstractRepository<Slot,Long>  {

    List<Slot> findByTypeId(Long id);
    int deleteByTypeId(Long id);
    long countByTypeCode(String code);
    List<Slot> findByPdpContainerId(Long id);
    int deleteByPdpContainerId(Long id);
    long countByPdpContainerId(Long id);


}
