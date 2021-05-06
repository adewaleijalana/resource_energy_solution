package com.resource.energy.service;


import com.resource.energy.domain.XCurrentAppUserDto;
import com.resource.energy.exception.ModelNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional
public interface AbstractService<T, PK extends Serializable> {


    T saveNew(final T entity, final XCurrentAppUserDto domainUser) throws ModelNotFoundException;

    List<T> saveNew(final List<T> entity, final XCurrentAppUserDto domainUser);

    T saveUpdate(final T entity, final XCurrentAppUserDto domainUser);

    void saveUpdate(final List<T> entity, final XCurrentAppUserDto domainUser) throws Exception;

    T delete(T entity);

    int deleteAll();

    void delete(List<T> entities);

   /* @Transactional(readOnly = true)
    Optional<T> findByID(PK id) throws ModelNotFoundException;
*/
    @Transactional(readOnly = true)
    boolean exists(PK id);

    @Transactional(readOnly = true)
    Long countLong();

    @Transactional(readOnly = true)
    Optional<T> findByEntity(T entity);

    @Transactional(readOnly = true)
    List<T> findAll();

    @Transactional(readOnly = true)
    Optional<T> findByIDWithRef(PK id);


}