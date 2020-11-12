/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.base.services;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E, PK extends Serializable> {

    E saveOrUpdate(E e);

    E findById(PK id);

    void deleteById(PK id);


    List<E> findAll();

    void delete(E e);
}

