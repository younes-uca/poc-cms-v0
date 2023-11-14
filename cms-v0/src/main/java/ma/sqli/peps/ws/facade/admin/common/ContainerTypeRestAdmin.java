package  ma.sqli.peps.ws.facade.admin.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.sqli.peps.bean.core.common.ContainerType;
import ma.sqli.peps.dao.criteria.core.common.ContainerTypeCriteria;
import ma.sqli.peps.service.facade.admin.common.ContainerTypeAdminService;
import ma.sqli.peps.ws.converter.common.ContainerTypeConverter;
import ma.sqli.peps.ws.dto.common.ContainerTypeDto;
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
@RequestMapping("/api/admin/containerType/")
public class ContainerTypeRestAdmin  extends AbstractController<ContainerType, ContainerTypeDto, ContainerTypeCriteria, ContainerTypeAdminService, ContainerTypeConverter> {



    @Operation(summary = "upload one containerType")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple containerTypes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all containerTypes")
    @GetMapping("")
    public ResponseEntity<List<ContainerTypeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all containerTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<ContainerTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a containerType by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ContainerTypeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a containerType by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<ContainerTypeDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ContainerType(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  containerType")
    @PostMapping("")
    public ResponseEntity<ContainerTypeDto> save(@RequestBody ContainerTypeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  containerType")
    @PutMapping("")
    public ResponseEntity<ContainerTypeDto> update(@RequestBody ContainerTypeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of containerType")
    @PostMapping("multiple")
    public ResponseEntity<List<ContainerTypeDto>> delete(@RequestBody List<ContainerTypeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified containerType")
    @DeleteMapping("")
    public ResponseEntity<ContainerTypeDto> delete(@RequestBody ContainerTypeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified containerType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple containerTypes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds containerTypes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ContainerTypeDto>> findByCriteria(@RequestBody ContainerTypeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated containerTypes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ContainerTypeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports containerTypes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ContainerTypeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets containerType data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ContainerTypeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ContainerTypeRestAdmin (ContainerTypeAdminService service, ContainerTypeConverter converter) {
        super(service, converter);
    }




}
