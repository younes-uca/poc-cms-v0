package  ma.sqli.peps.ws.facade.admin.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.sqli.peps.bean.core.common.SlotType;
import ma.sqli.peps.dao.criteria.core.common.SlotTypeCriteria;
import ma.sqli.peps.service.facade.admin.common.SlotTypeAdminService;
import ma.sqli.peps.ws.converter.common.SlotTypeConverter;
import ma.sqli.peps.ws.dto.common.SlotTypeDto;
import ma.sqli.peps.zynerator.controller.AbstractController;
import ma.sqli.peps.zynerator.dto.AuditEntityDto;
import ma.sqli.peps.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sqli.peps.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sqli.peps.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/slotType/")
public class SlotTypeRestAdmin  extends AbstractController<SlotType, SlotTypeDto, SlotTypeCriteria, SlotTypeAdminService, SlotTypeConverter> {



    @Operation(summary = "upload one slotType")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple slotTypes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all slotTypes")
    @GetMapping("")
    public ResponseEntity<List<SlotTypeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all slotTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<SlotTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a slotType by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SlotTypeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a slotType by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<SlotTypeDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new SlotType(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  slotType")
    @PostMapping("")
    public ResponseEntity<SlotTypeDto> save(@RequestBody SlotTypeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  slotType")
    @PutMapping("")
    public ResponseEntity<SlotTypeDto> update(@RequestBody SlotTypeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of slotType")
    @PostMapping("multiple")
    public ResponseEntity<List<SlotTypeDto>> delete(@RequestBody List<SlotTypeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified slotType")
    @DeleteMapping("")
    public ResponseEntity<SlotTypeDto> delete(@RequestBody SlotTypeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified slotType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple slotTypes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds slotTypes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SlotTypeDto>> findByCriteria(@RequestBody SlotTypeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated slotTypes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SlotTypeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports slotTypes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SlotTypeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets slotType data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SlotTypeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SlotTypeRestAdmin (SlotTypeAdminService service, SlotTypeConverter converter) {
        super(service, converter);
    }




}
