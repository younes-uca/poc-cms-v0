package ma.sqli.peps.service.facade.admin.container;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import ma.sqli.peps.bean.core.container.PdpContainer;
import ma.sqli.peps.dao.criteria.core.container.PdpContainerCriteria;
import ma.sqli.peps.service.impl.admin.container.PdpContainerAdminServiceImpl;
import ma.sqli.peps.zynerator.service.IService;
import org.springframework.kafka.annotation.KafkaListener;


public interface PdpContainerAdminService extends  IService<PdpContainer,PdpContainerCriteria>  {

    PdpContainer receive(String buyingFrameDtoAsString) throws JsonProcessingException;

    List<PdpContainer> findByTypeId(Long id);
    int deleteByTypeId(Long id);
    long countByTypeCode(String code);
    List<PdpContainer> findByVersionId(Long id);
    int deleteByVersionId(Long id);
    long countByVersionCode(String code);



}
