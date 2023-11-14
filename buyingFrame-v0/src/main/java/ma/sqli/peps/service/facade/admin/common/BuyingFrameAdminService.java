package ma.sqli.peps.service.facade.admin.common;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import ma.sqli.peps.bean.core.common.BuyingFrame;
import ma.sqli.peps.dao.criteria.core.common.BuyingFrameCriteria;
import ma.sqli.peps.zynerator.service.IService;



public interface BuyingFrameAdminService extends  IService<BuyingFrame,BuyingFrameCriteria>  {


    void send(BuyingFrame buyingFrame) throws JsonProcessingException;
}
