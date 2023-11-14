package  ma.sqli.peps.ws.facade.admin.container;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.sqli.peps.bean.core.container.PdpContainer;
import ma.sqli.peps.dao.criteria.core.container.PdpContainerCriteria;
import ma.sqli.peps.service.facade.admin.container.PdpContainerAdminService;
import ma.sqli.peps.ws.converter.container.PdpContainerConverter;
import ma.sqli.peps.ws.dto.container.PdpContainerDto;
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
@RequestMapping("/api/admin/pdpContainer/")
public class PdpContainerRestAdmin  extends AbstractController<PdpContainer, PdpContainerDto, PdpContainerCriteria, PdpContainerAdminService, PdpContainerConverter> {



    @Operation(summary = "upload one pdpContainer")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple pdpContainers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all pdpContainers")
    @GetMapping("")
    public ResponseEntity<List<PdpContainerDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a pdpContainer by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PdpContainerDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  pdpContainer")
    @PostMapping("")
    public ResponseEntity<PdpContainerDto> save(@RequestBody PdpContainerDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  pdpContainer")
    @PutMapping("")
    public ResponseEntity<PdpContainerDto> update(@RequestBody PdpContainerDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of pdpContainer")
    @PostMapping("multiple")
    public ResponseEntity<List<PdpContainerDto>> delete(@RequestBody List<PdpContainerDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified pdpContainer")
    @DeleteMapping("")
    public ResponseEntity<PdpContainerDto> delete(@RequestBody PdpContainerDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified pdpContainer")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple pdpContainers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by type id")
    @GetMapping("type/id/{id}")
    public List<PdpContainerDto> findByTypeId(@PathVariable Long id){
        return findDtos(service.findByTypeId(id));
    }
    @Operation(summary = "delete by type id")
    @DeleteMapping("type/id/{id}")
    public int deleteByTypeId(@PathVariable Long id){
        return service.deleteByTypeId(id);
    }
    @Operation(summary = "find by version id")
    @GetMapping("version/id/{id}")
    public List<PdpContainerDto> findByVersionId(@PathVariable Long id){
        return findDtos(service.findByVersionId(id));
    }
    @Operation(summary = "delete by version id")
    @DeleteMapping("version/id/{id}")
    public int deleteByVersionId(@PathVariable Long id){
        return service.deleteByVersionId(id);
    }
    @Operation(summary = "Finds a pdpContainer and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<PdpContainerDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds pdpContainers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PdpContainerDto>> findByCriteria(@RequestBody PdpContainerCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated pdpContainers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PdpContainerCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports pdpContainers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PdpContainerCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets pdpContainer data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PdpContainerCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PdpContainerRestAdmin (PdpContainerAdminService service, PdpContainerConverter converter) {
        super(service, converter);
    }




}
