/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.Dao.impl;

import ir.ac.kntu.Dao.CityRepository;
import ir.ac.kntu.base.repository.impl.BaseRepositoryImpl;
import ir.ac.kntu.domains.City;

import javax.persistence.TypedQuery;
import java.util.List;

public class CityRepositoryImpl extends BaseRepositoryImpl<City, Long> implements CityRepository {
    @Override
    protected Class<City> getEntityClass() {
        return City.class;
    }


    @Override
    public City findByName(String city) {
        em.getTransaction().begin();
        TypedQuery<City> query = em.createQuery(
                "SELECT u FROM City u where u.name=:city",
                City.class);

        query.setParameter("city", city);
        List<City> resultList = query.getResultList();
        em.getTransaction().commit();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
