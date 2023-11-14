package  ma.sqli.peps.ws.facade.admin.container;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.sqli.peps.bean.core.container.Slot;
import ma.sqli.peps.dao.criteria.core.container.SlotCriteria;
import ma.sqli.peps.service.facade.admin.container.SlotAdminService;
import ma.sqli.peps.ws.converter.container.SlotConverter;
import ma.sqli.peps.ws.dto.container.SlotDto;
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
@RequestMapping("/api/admin/slot/")
public class SlotRestAdmin  extends AbstractController<Slot, SlotDto, SlotCriteria, SlotAdminService, SlotConverter> {



    @Operation(summary = "upload one slot")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple slots")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all slots")
    @GetMapping("")
    public ResponseEntity<List<SlotDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a slot by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SlotDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  slot")
    @PostMapping("")
    public ResponseEntity<SlotDto> save(@RequestBody SlotDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  slot")
    @PutMapping("")
    public ResponseEntity<SlotDto> update(@RequestBody SlotDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of slot")
    @PostMapping("multiple")
    public ResponseEntity<List<SlotDto>> delete(@RequestBody List<SlotDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified slot")
    @DeleteMapping("")
    public ResponseEntity<SlotDto> delete(@RequestBody SlotDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified slot")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple slots by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by type id")
    @GetMapping("type/id/{id}")
    public List<SlotDto> findByTypeId(@PathVariable Long id){
        return findDtos(service.findByTypeId(id));
    }
    @Operation(summary = "delete by type id")
    @DeleteMapping("type/id/{id}")
    public int deleteByTypeId(@PathVariable Long id){
        return service.deleteByTypeId(id);
    }
    @Operation(summary = "find by pdpContainer id")
    @GetMapping("pdpContainer/id/{id}")
    public List<SlotDto> findByPdpContainerId(@PathVariable Long id){
        return findDtos(service.findByPdpContainerId(id));
    }
    @Operation(summary = "delete by pdpContainer id")
    @DeleteMapping("pdpContainer/id/{id}")
    public int deleteByPdpContainerId(@PathVariable Long id){
        return service.deleteByPdpContainerId(id);
    }
    @Operation(summary = "Finds slots by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SlotDto>> findByCriteria(@RequestBody SlotCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated slots by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SlotCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports slots by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SlotCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets slot data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SlotCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SlotRestAdmin (SlotAdminService service, SlotConverter converter) {
        super(service, converter);
    }




}
