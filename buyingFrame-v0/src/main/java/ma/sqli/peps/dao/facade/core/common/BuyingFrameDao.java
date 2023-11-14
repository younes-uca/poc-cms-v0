package ma.sqli.peps.dao.facade.core.common;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.peps.zynerator.repository.AbstractRepository;
import ma.sqli.peps.bean.core.common.BuyingFrame;
import org.springframework.stereotype.Repository;
import ma.sqli.peps.bean.core.common.BuyingFrame;
import java.util.List;


@Repository
public interface BuyingFrameDao extends AbstractRepository<BuyingFrame,Long>  {
    BuyingFrame findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW BuyingFrame(item.id,item.libelle) FROM BuyingFrame item")
    List<BuyingFrame> findAllOptimized();

}
