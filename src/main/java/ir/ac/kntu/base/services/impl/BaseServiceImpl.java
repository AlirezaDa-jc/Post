/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.base.services.impl;


import ir.ac.kntu.base.repository.BaseRepository;
import ir.ac.kntu.base.services.BaseService;

import java.util.List;

public class BaseServiceImpl<E, PK extends Number, Repository extends BaseRepository<E, PK>> implements
        BaseService<E, PK> {

    protected Repository baseRepository;

    public BaseServiceImpl() {
    }

    public BaseServiceImpl(Repository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public E saveOrUpdate(E e) {
        return baseRepository.saveOrUpdate(e);
    }

    @Override
    public E findById(PK id) {
        return baseRepository.findById(id);
    }

    @Override
    public void deleteById(PK id) {
        baseRepository.deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public void delete(E e) {
        baseRepository.delete(e);
    }

    protected void setRepository(Repository repository) {
        baseRepository = repository;
    }
}

