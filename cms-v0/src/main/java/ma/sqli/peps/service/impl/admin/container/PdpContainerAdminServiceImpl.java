package ma.sqli.peps.service.impl.admin.container;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.sqli.peps.bean.core.common.SlotType;
import ma.sqli.peps.bean.core.container.PdpContainer;
import ma.sqli.peps.bean.core.container.Slot;
import ma.sqli.peps.dao.criteria.core.container.PdpContainerCriteria;
import ma.sqli.peps.dao.facade.core.container.PdpContainerDao;
import ma.sqli.peps.dao.specification.core.container.PdpContainerSpecification;
import ma.sqli.peps.requiered.dto.BuyingFrameDto;
import ma.sqli.peps.service.facade.admin.common.ContainerTypeAdminService;
import ma.sqli.peps.service.facade.admin.common.ContainerVersionAdminService;
import ma.sqli.peps.service.facade.admin.common.ProductTypeAdminService;
import ma.sqli.peps.service.facade.admin.container.PdpContainerAdminService;
import ma.sqli.peps.service.facade.admin.container.SlotAdminService;
import ma.sqli.peps.zynerator.service.AbstractServiceImpl;
import ma.sqli.peps.zynerator.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PdpContainerAdminServiceImpl extends AbstractServiceImpl<PdpContainer, PdpContainerCriteria, PdpContainerDao> implements PdpContainerAdminService {

    public static final String BUYING_FRAME_V_2 = "buying-frame-v2";
    public static final String BUYING_FRAME_V_2_CONSUMER_ID = "buying-frame-consumer-1";

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public PdpContainer create(PdpContainer t) {
        PdpContainer pdpContainer = super.create(t);
        if (pdpContainer != null) {
            if (t.getSlots() != null) {
                t.getSlots().forEach(element-> {
                    element.setPdpContainer(t);
                    slotService.create(element);
                });
            }
        }
        return t;
    }

    @Override
    @KafkaListener(topics = "buying-frame-v2", groupId = "buying-frame-consumer-1")
    public PdpContainer receive(String buyingFrameDtoAsString) throws JsonProcessingException {
        BuyingFrameDto buyingFrameDto = new BuyingFrameDto(buyingFrameDtoAsString);
        System.out.println("**************** received :::: buyingFrameDto = " + buyingFrameDto);
        PdpContainer pdpContainer = constructPdp(buyingFrameDto);

        if(System.currentTimeMillis()%2 == 0){
            Slot slot11 = new Slot(new SlotType( 1L,"slot-type-1"));
            Slot slot12 = new Slot(new SlotType(2L,"slot-type-2"));
            pdpContainer.setSlots(Stream.of(slot11,slot12).collect(Collectors.toList()));
        }else{
            Slot slot21 = new Slot(new SlotType(3L,"slot-type-3"));
            Slot slot22 = new Slot(new SlotType(5L,"slot-type-4"));
            Slot slot23 = new Slot(new SlotType(6L,"slot-type-5"));
            pdpContainer.setSlots(Stream.of(slot21,slot22,slot23).collect(Collectors.toList()));
        }
        return create(pdpContainer);
    }

    private PdpContainer constructPdp( BuyingFrameDto buyingFrameDto) {
        PdpContainer pdpContainer = new PdpContainer();
        pdpContainer.setBuyingFrame(buyingFrameDto.getCode());
        pdpContainer.setLabel(buyingFrameDto.getCode());
        pdpContainer.setCode(buyingFrameDto.getCode());
        return pdpContainer;
    }

    public PdpContainer findWithAssociatedLists(Long id){
        PdpContainer result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSlots(slotService.findByPdpContainerId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        slotService.deleteByPdpContainerId(id);
    }


    public void updateWithAssociatedLists(PdpContainer pdpContainer){
    if(pdpContainer !=null && pdpContainer.getId() != null){
            List<List<Slot>> resultSlots= slotService.getToBeSavedAndToBeDeleted(slotService.findByPdpContainerId(pdpContainer.getId()),pdpContainer.getSlots());
            slotService.delete(resultSlots.get(1));
            ListUtil.emptyIfNull(resultSlots.get(0)).forEach(e -> e.setPdpContainer(pdpContainer));
            slotService.update(resultSlots.get(0),true);
    }
    }




    public List<PdpContainer> findByTypeId(Long id){
        return dao.findByTypeId(id);
    }
    public int deleteByTypeId(Long id){
        return dao.deleteByTypeId(id);
    }
    public long countByTypeCode(String code){
        return dao.countByTypeCode(code);
    }
    public List<PdpContainer> findByVersionId(Long id){
        return dao.findByVersionId(id);
    }
    public int deleteByVersionId(Long id){
        return dao.deleteByVersionId(id);
    }
    public long countByVersionCode(String code){
        return dao.countByVersionCode(code);
    }






    public void configure() {
        super.configure(PdpContainer.class, PdpContainerSpecification.class);
    }


    @Autowired
    private ContainerVersionAdminService containerVersionService ;
    @Autowired
    private ContainerTypeAdminService containerTypeService ;
    @Autowired
    private SlotAdminService slotService ;
    @Autowired
    private ProductTypeAdminService productTypeService ;

    public PdpContainerAdminServiceImpl(PdpContainerDao dao) {
        super(dao);
    }

}
