package ma.sqli.peps.zynerator.service;

import ma.sqli.peps.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sqli.peps.zynerator.criteria.BaseCriteria;
import ma.sqli.peps.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
