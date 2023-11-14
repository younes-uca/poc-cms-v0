package ma.sqli.peps.dao.facade.core.container;

import ma.sqli.peps.zynerator.repository.AbstractRepository;
import ma.sqli.peps.bean.core.container.PdpContainer;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PdpContainerDao extends AbstractRepository<PdpContainer,Long>  {

    List<PdpContainer> findByTypeId(Long id);
    int deleteByTypeId(Long id);
    long countByTypeCode(String code);
    List<PdpContainer> findByVersionId(Long id);
    int deleteByVersionId(Long id);
    long countByVersionCode(String code);


}
