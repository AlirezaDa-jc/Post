import ir.ac.kntu.Dao.CityRepository;
import ir.ac.kntu.Dao.impl.CityRepositoryImpl;
import ir.ac.kntu.domains.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alireza.d.a
 */
class CityRepositoryImplTest extends CityRepositoryImpl {
    private static final CityRepository cityRepository = new CityRepositoryImpl();
    private static final City firstCity = new City("first", "17S 18N");
    private static final City secondCity = new City("second", "14S 11N");
    private static final City thirdCity = new City("third", "99N 55S");

    @BeforeAll
    static void beforeAll() {

        cityRepository.saveOrUpdate(firstCity);
        cityRepository.saveOrUpdate(secondCity);
        cityRepository.saveOrUpdate(thirdCity);
    }


    @Override
    protected Class<City> getEntityClass() {
        return super.getEntityClass();
    }

    @Order(1)
    @Test
    void testFindByName() {
        Assertions.assertEquals(firstCity, findByName("first"));
        Assertions.assertEquals(secondCity, findByName("second"));
    }

    @Order(3)
    @Test
    void testFindById() {
        assertEquals(firstCity, findById(firstCity.getId()));
        try {
            assertEquals(thirdCity, findById(thirdCity.getId()));
        } catch (Exception ex) {
            System.out.println("Correct!");
        }
    }

    @Order(2)
    @Test
    void testDeleteById() {
        deleteById(thirdCity.getId());
    }

    @Order(4)
    @Test
    void testFindAll() {
        List<City> cities = new LinkedList<>();
        cities.add(firstCity);
        cities.add(secondCity);
        assertEquals(cities, findAll());
    }

}