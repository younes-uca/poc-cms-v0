package  ma.sqli.peps.ws.facade.admin.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.sqli.peps.bean.core.common.ContainerVersion;
import ma.sqli.peps.dao.criteria.core.common.ContainerVersionCriteria;
import ma.sqli.peps.service.facade.admin.common.ContainerVersionAdminService;
import ma.sqli.peps.ws.converter.common.ContainerVersionConverter;
import ma.sqli.peps.ws.dto.common.ContainerVersionDto;
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
@RequestMapping("/api/admin/containerVersion/")
public class ContainerVersionRestAdmin  extends AbstractController<ContainerVersion, ContainerVersionDto, ContainerVersionCriteria, ContainerVersionAdminService, ContainerVersionConverter> {



    @Operation(summary = "upload one containerVersion")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple containerVersions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all containerVersions")
    @GetMapping("")
    public ResponseEntity<List<ContainerVersionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all containerVersions")
    @GetMapping("optimized")
    public ResponseEntity<List<ContainerVersionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a containerVersion by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ContainerVersionDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a containerVersion by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<ContainerVersionDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ContainerVersion(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  containerVersion")
    @PostMapping("")
    public ResponseEntity<ContainerVersionDto> save(@RequestBody ContainerVersionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  containerVersion")
    @PutMapping("")
    public ResponseEntity<ContainerVersionDto> update(@RequestBody ContainerVersionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of containerVersion")
    @PostMapping("multiple")
    public ResponseEntity<List<ContainerVersionDto>> delete(@RequestBody List<ContainerVersionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified containerVersion")
    @DeleteMapping("")
    public ResponseEntity<ContainerVersionDto> delete(@RequestBody ContainerVersionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified containerVersion")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple containerVersions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds containerVersions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ContainerVersionDto>> findByCriteria(@RequestBody ContainerVersionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated containerVersions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ContainerVersionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports containerVersions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ContainerVersionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets containerVersion data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ContainerVersionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ContainerVersionRestAdmin (ContainerVersionAdminService service, ContainerVersionConverter converter) {
        super(service, converter);
    }




}
