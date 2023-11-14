package  ma.sqli.peps.ws.facade.admin.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.sqli.peps.bean.core.common.ProductType;
import ma.sqli.peps.dao.criteria.core.common.ProductTypeCriteria;
import ma.sqli.peps.service.facade.admin.common.ProductTypeAdminService;
import ma.sqli.peps.ws.converter.common.ProductTypeConverter;
import ma.sqli.peps.ws.dto.common.ProductTypeDto;
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
@RequestMapping("/api/admin/productType/")
public class ProductTypeRestAdmin  extends AbstractController<ProductType, ProductTypeDto, ProductTypeCriteria, ProductTypeAdminService, ProductTypeConverter> {



    @Operation(summary = "upload one productType")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple productTypes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all productTypes")
    @GetMapping("")
    public ResponseEntity<List<ProductTypeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all productTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<ProductTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a productType by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProductTypeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a productType by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<ProductTypeDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ProductType(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  productType")
    @PostMapping("")
    public ResponseEntity<ProductTypeDto> save(@RequestBody ProductTypeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  productType")
    @PutMapping("")
    public ResponseEntity<ProductTypeDto> update(@RequestBody ProductTypeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of productType")
    @PostMapping("multiple")
    public ResponseEntity<List<ProductTypeDto>> delete(@RequestBody List<ProductTypeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified productType")
    @DeleteMapping("")
    public ResponseEntity<ProductTypeDto> delete(@RequestBody ProductTypeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified productType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple productTypes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds productTypes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProductTypeDto>> findByCriteria(@RequestBody ProductTypeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated productTypes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProductTypeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports productTypes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProductTypeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets productType data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProductTypeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ProductTypeRestAdmin (ProductTypeAdminService service, ProductTypeConverter converter) {
        super(service, converter);
    }




}
