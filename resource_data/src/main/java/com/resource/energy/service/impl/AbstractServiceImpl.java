package com.resource.energy.service.impl;


import com.resource.energy.domain.XCurrentAppUserDto;
import com.resource.energy.domain.xtras.AbstractEntity;
import com.resource.energy.exception.ModelNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class AbstractServiceImpl<T extends AbstractEntity<PK>, PK extends Serializable> {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AbstractServiceImpl.class);

    @Autowired
    protected JpaRepository<T, PK> getDao;

    protected Class<T> type;
//    protected Logger log;


    /**
     * This constructor needs the real type of the generic
     * type T so it can be given to the {@link EntityManager}.
     */
    public AbstractServiceImpl(Class<T> type) {
        this.type = type;
//        this.log = Logger.getLogger(type.getName());
    }


    private T enrichEntity(final T entity, XCurrentAppUserDto domainUser) {
        T resp = null;

        log.debug("about enriching entity");
//		entity.setId(ID.generateUUIDString());

        /**
         * IF USER ACCOUNT IS NULL PLEASE DEFAULT TO a@a.com
         * TODO: FOR DEVELOPMENT PURPOSES ONLY
         */
        if (domainUser == null)
            domainUser = new XCurrentAppUserDto("a@a.com", "password", AuthorityUtils.NO_AUTHORITIES, "SYSTEM");

//		if ((entity != null) && (entity.isIdSet())) {
        if ((entity != null)) {
            entity.setCreatedBy(domainUser.getCurrentUserId());
            entity.setCreatedDate(ZonedDateTime.now());
            resp = entity;
        } else {
            log.error("Entity ID not set, or Entity is Null");
        }
        log.debug("finished enriching entity");

        return resp;
    }

    private List<T> enrichEntity(final List<T> entityList, final XCurrentAppUserDto userAccount) {
        log.debug("about enriching entity");
        List<T> array = new ArrayList<>();

        entityList.stream()
                .filter(t -> (t != null))
                .forEach(t -> {
                    array.add(enrichEntity(t, userAccount));
                });
        log.debug("finished enriching entity");

        return array;
    }


    @Transactional(readOnly = false)
    public T saveNew(final T entity, final XCurrentAppUserDto userAccount) throws ModelNotFoundException {
        log.debug("about saving entity");
        T resp = null;
        T enrEntity = enrichEntity(entity, userAccount);

        if (enrEntity != null) {
            try {
                resp = getDao.save(entity);
                getDao.flush();

                //if (getDao.findOne(resp.getPk()) != null) {
                if (getDao.findById(resp.getPk()).isPresent()) {
                    log.debug("finished saving entity with id - {} " + resp.getPk());
                } else {
                    log.error("error occurred while saving entity");
                }
                return resp;
            } catch (ModelNotFoundException e) {
                log.error(e.getMessage(), e);
                throw e;
            }
        }
        log.error("error occurred while saving entity");
        return resp;
    }

    @Transactional(readOnly = false)
    public List<T> saveNew(final List<T> entityList, XCurrentAppUserDto userAccount) {
        log.debug("about saving entity");
        List<T> tList = null;
        try {

            List<T> array = enrichEntity(entityList, userAccount);
            //getDao.save(array);
            getDao.saveAll(array);
            getDao.flush();
            tList = array;
        } finally {
            log.debug("finished saving entity");
        }
        return tList;


    }

    @Transactional(readOnly = false)
    public T saveUpdate(final T entity, final XCurrentAppUserDto userAccount) {

        XCurrentAppUserDto domainUser = userAccount;

        if (domainUser == null)
            domainUser = new XCurrentAppUserDto("a@a.com", "password", AuthorityUtils.NO_AUTHORITIES, "SYSTEM");


        try {
            if ((entity != null) && (entity.isIdSet())) {
                entity.setLastModifiedBy(domainUser.getCurrentUserId());
                entity.setLastModifiedDate(ZonedDateTime.now());
                getDao.save(entity);
            }
            //return getDao.findOne(entity.getPk());
            return getDao.findById(entity.getPk()).get();
        } catch (PersistenceException e) {

        } catch (Exception e) {
        }
        return null;
    }

    @Transactional(readOnly = false)
    public void saveUpdate(final List<T> entityList, final XCurrentAppUserDto userAccount) {

        XCurrentAppUserDto domainUser = userAccount;

        if (domainUser == null)
            domainUser = new XCurrentAppUserDto("a@a.com", "password", AuthorityUtils.NO_AUTHORITIES, "SYSTEM");


        try {
            List<T> newList = new ArrayList<T>();
            if ((entityList != null) && (!entityList.isEmpty())) {
                for (T entity : entityList) {
                    entity.setLastModifiedBy(domainUser.getCurrentUserId());
                    entity.setLastModifiedDate(ZonedDateTime.now());
                    newList.add(entity);
                }
            }
            //getDao.save(newList);
            getDao.saveAll(newList);
        } catch (PersistenceException e) {

        } catch (Exception e) {

        }
    }


    public T delete(T entity) {
        getDao.delete(entity);
        return getDao.findById(entity.getPk()).get();
    }


//	public void delete(List<PK> list, String idProperty) {
//
//		getDao().delete(list,idProperty);
//	}

    public int deleteAll() {
//		return getDao().deleteAllInBatch();
        int size = findAll().size();

        for (T element : findAll()) {
            delete(element);
        }
        return size;
    }

    public void delete(List<T> entities) {
        getDao.deleteAll(entities);
    }

    public boolean exists(PK id) {
        //return getDao.exists(id);
        return getDao.existsById(id);
    }

    @Transactional(readOnly = true)
    public Long countLong() {
        return getDao.count();
    }

    @Transactional(readOnly = true)
    public Integer countInt() {
        return countLong().intValue();
    }


    @Transactional(readOnly = true)
    public Optional<T> findByID(PK id) throws ModelNotFoundException {
        return getDao.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<T> findByEntity(T entity) {
        return getDao.findById(entity.getPk());
    }

    public List<T> findAll() {
        return getDao.findAll();
    }


}
