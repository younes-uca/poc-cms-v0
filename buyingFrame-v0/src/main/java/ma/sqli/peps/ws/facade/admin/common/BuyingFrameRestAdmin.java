package ma.sqli.peps.ws.facade.admin.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import ma.sqli.peps.bean.core.common.BuyingFrame;
import ma.sqli.peps.dao.criteria.core.common.BuyingFrameCriteria;
import ma.sqli.peps.service.facade.admin.common.BuyingFrameAdminService;
import ma.sqli.peps.ws.converter.common.BuyingFrameConverter;
import ma.sqli.peps.ws.dto.common.BuyingFrameDto;
import ma.sqli.peps.zynerator.controller.AbstractController;
import ma.sqli.peps.zynerator.dto.FileTempDto;
import ma.sqli.peps.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin/buyingFrame/")
public class BuyingFrameRestAdmin extends AbstractController<BuyingFrame, BuyingFrameDto, BuyingFrameCriteria, BuyingFrameAdminService, BuyingFrameConverter> {


    @Operation(summary = "upload one buyingFrame")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @Operation(summary = "upload multiple buyingFrames")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all buyingFrames")
    @GetMapping("")
    public ResponseEntity<List<BuyingFrameDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all buyingFrames")
    @GetMapping("optimized")
    public ResponseEntity<List<BuyingFrameDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a buyingFrame by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BuyingFrameDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a buyingFrame by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<BuyingFrameDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new BuyingFrame(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  buyingFrame")
    @PostMapping("")
    public ResponseEntity<BuyingFrameDto> save(@RequestBody BuyingFrameDto dto) throws Exception {
        return super.save(dto);
    }

    /*
    POST
    http://localhost:8037/api/admin/buyingFrame/send
    {
        "code":"bf-code-12",
        "libelle":"bf-libelle-12"
    }
     */
    @Operation(summary = "send buyingFrame using Kafka Topic")
    @PostMapping("send")
    public ResponseEntity<String> send(@RequestBody BuyingFrameDto dto) {
        BuyingFrame item = converter.toItem(dto);
        try {
            service.send(item);
            return new ResponseEntity<>("Buying Frame saved and sent", HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Buying Frame sending error", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Operation(summary = "Updates the specified  buyingFrame")
    @PutMapping("")
    public ResponseEntity<BuyingFrameDto> update(@RequestBody BuyingFrameDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of buyingFrame")
    @PostMapping("multiple")
    public ResponseEntity<List<BuyingFrameDto>> delete(@RequestBody List<BuyingFrameDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @Operation(summary = "Delete the specified buyingFrame")
    @DeleteMapping("")
    public ResponseEntity<BuyingFrameDto> delete(@RequestBody BuyingFrameDto dto) throws Exception {
        return super.delete(dto);
    }

    @Operation(summary = "Delete the specified buyingFrame")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @Operation(summary = "Delete multiple buyingFrames by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }


    @Operation(summary = "Finds buyingFrames by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BuyingFrameDto>> findByCriteria(@RequestBody BuyingFrameCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated buyingFrames by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BuyingFrameCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports buyingFrames by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BuyingFrameCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets buyingFrame data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BuyingFrameCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }


    public BuyingFrameRestAdmin(BuyingFrameAdminService service, BuyingFrameConverter converter) {
        super(service, converter);
    }


}
