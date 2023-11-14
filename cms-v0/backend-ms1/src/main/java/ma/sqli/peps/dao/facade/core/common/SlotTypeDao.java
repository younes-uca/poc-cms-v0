package ma.sqli.peps.dao.facade.core.common;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.peps.zynerator.repository.AbstractRepository;
import ma.sqli.peps.bean.core.common.SlotType;
import org.springframework.stereotype.Repository;
import ma.sqli.peps.bean.core.common.SlotType;
import java.util.List;


@Repository
public interface SlotTypeDao extends AbstractRepository<SlotType,Long>  {
    SlotType findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW SlotType(item.id,item.libelle) FROM SlotType item")
    List<SlotType> findAllOptimized();

}
