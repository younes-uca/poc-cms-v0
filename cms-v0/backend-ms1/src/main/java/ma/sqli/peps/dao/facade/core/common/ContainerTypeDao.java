package ma.sqli.peps.dao.facade.core.common;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.peps.zynerator.repository.AbstractRepository;
import ma.sqli.peps.bean.core.common.ContainerType;
import org.springframework.stereotype.Repository;
import ma.sqli.peps.bean.core.common.ContainerType;
import java.util.List;


@Repository
public interface ContainerTypeDao extends AbstractRepository<ContainerType,Long>  {
    ContainerType findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ContainerType(item.id,item.libelle) FROM ContainerType item")
    List<ContainerType> findAllOptimized();

}
