package ma.sqli.peps.dao.facade.core.common;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.peps.zynerator.repository.AbstractRepository;
import ma.sqli.peps.bean.core.common.ContainerVersion;
import org.springframework.stereotype.Repository;
import ma.sqli.peps.bean.core.common.ContainerVersion;
import java.util.List;


@Repository
public interface ContainerVersionDao extends AbstractRepository<ContainerVersion,Long>  {
    ContainerVersion findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ContainerVersion(item.id,item.libelle) FROM ContainerVersion item")
    List<ContainerVersion> findAllOptimized();

}
