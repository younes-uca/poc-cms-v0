package ma.sqli.peps.service.impl.admin.common;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.sqli.peps.bean.core.common.BuyingFrame;
import ma.sqli.peps.dao.criteria.core.common.BuyingFrameCriteria;
import ma.sqli.peps.dao.facade.core.common.BuyingFrameDao;
import ma.sqli.peps.dao.specification.core.common.BuyingFrameSpecification;
import ma.sqli.peps.service.facade.admin.common.BuyingFrameAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import java.util.concurrent.CompletableFuture;

@Service
public class BuyingFrameAdminServiceImpl extends AbstractServiceImpl<BuyingFrame, BuyingFrameCriteria, BuyingFrameDao> implements BuyingFrameAdminService {


    public static final String TOPIC = "demo2";
    @Autowired
    private KafkaTemplate<String, Object> template; // Spring cloud Stream
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void send(BuyingFrame buyingFrame) throws JsonProcessingException {
        if (findByReferenceEntity(buyingFrame) == null) {
            String data = objectMapper.writeValueAsString(buyingFrame);
            CompletableFuture<SendResult<String, Object>> future = template.send(TOPIC, data);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + data + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                    super.create(buyingFrame);
                } else {
                    System.out.println("Unable to send message=[" + data + "] due to : " + ex.getMessage());
                }
            });
        }


    }

    public BuyingFrame findByReferenceEntity(BuyingFrame t) {
        return dao.findByCode(t.getCode());
    }


    public List<BuyingFrame> findAllOptimized() {
        return dao.findAllOptimized();
    }


    public void configure() {
        super.configure(BuyingFrame.class, BuyingFrameSpecification.class);
    }


    public BuyingFrameAdminServiceImpl(BuyingFrameDao dao) {
        super(dao);
    }

}
