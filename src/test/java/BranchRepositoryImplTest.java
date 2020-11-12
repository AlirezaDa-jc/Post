/**
 * @author Alireza.d.a
 */

import ir.ac.kntu.Dao.BranchRepository;
import ir.ac.kntu.Dao.CityRepository;
import ir.ac.kntu.Dao.impl.BranchRepositoryImpl;
import ir.ac.kntu.Dao.impl.CityRepositoryImpl;
import ir.ac.kntu.domains.Branch;
import ir.ac.kntu.domains.City;
import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BranchRepositoryImplTest extends BranchRepositoryImpl {
    private static final BranchRepository branchRepository = new BranchRepositoryImpl();

    private static final CityRepository cityRepository = new CityRepositoryImpl();
    private static Branch firstBranch;
    private static Branch secondBranch;

    @BeforeAll
    static void beforeAll() {
        List<City> cities = cityRepository.findAll();
        firstBranch = new Branch(10, cities.get(0));
        secondBranch = new Branch(10, cities.get(1));
        System.out.println(cities.get(0));
        System.out.println(cities.get(1));
        branchRepository.saveOrUpdate(firstBranch);
        branchRepository.saveOrUpdate(secondBranch);
    }

    @Order(1)
    @Test
    void testFindById() {
        Assertions.assertEquals(firstBranch, findById(firstBranch.getId()));
    }

    @Order(2)
    @Test
    void testFindAll() {
        List<Branch> branches = new LinkedList<>();
        branches.add(secondBranch);
        branches.add(firstBranch);
        assertEquals(branches, findAll());
    }

    @Override
    protected Class<Branch> getEntityClass() {
        return super.getEntityClass();
    }
}