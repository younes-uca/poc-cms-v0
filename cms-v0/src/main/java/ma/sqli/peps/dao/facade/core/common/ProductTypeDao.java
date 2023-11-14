package ma.sqli.peps.dao.facade.core.common;

import org.springframework.data.jpa.repository.Query;
import ma.sqli.peps.zynerator.repository.AbstractRepository;
import ma.sqli.peps.bean.core.common.ProductType;
import org.springframework.stereotype.Repository;
import ma.sqli.peps.bean.core.common.ProductType;
import java.util.List;


@Repository
public interface ProductTypeDao extends AbstractRepository<ProductType,Long>  {
    ProductType findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ProductType(item.id,item.libelle) FROM ProductType item")
    List<ProductType> findAllOptimized();

}
