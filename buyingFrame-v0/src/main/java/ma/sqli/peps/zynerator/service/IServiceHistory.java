package ma.sqli.peps.zynerator.service;

import ma.sqli.peps.zynerator.bean.BusinessObject;
import ma.sqli.peps.zynerator.criteria.BaseCriteria;
import ma.sqli.peps.zynerator.dto.AuditEntityDto;
import ma.sqli.peps.zynerator.security.bean.User;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface IServiceHistory<T extends BusinessObject, HistoryCriteria> {

    T create(T t);

    T update(T t);

    List<T> update(List<T> ts,boolean createIfNotExist);

    T findById(Long id);

    T findOrSave(T t);

    void findOrSaveAssociatedObject(T t);

    T findByReferenceEntity(T t);

    T findWithAssociatedLists(Long id);

    void deleteWithAssociatedLists(T t);

    List<T> findAllOptimized();

    void delete(List<T> ts);

    void deleteByIdIn(List<Long> ids);

    void deleteById(Long id);

    List<List<T>> getToBeSavedAndToBeDeleted(List<T> oldList, List<T> newList);

    User getCurrentUser();


    // History

    AuditEntityDto findHistoryById(Long id);

    List<AuditEntityDto> findHistoryByCriteria(HistoryCriteria historyCriteria);

    List<AuditEntityDto> findHistoryPaginatedByCriteria(HistoryCriteria historyCriteria, int page, int pageSize, String order, String sortField);

    int getHistoryDataSize(HistoryCriteria historyCriteria);

    List<T> importerData(List<T> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<T> importExcel(MultipartFile file);
}