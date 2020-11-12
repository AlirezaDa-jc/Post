package ir.ac.kntu.services.impl;

import ir.ac.kntu.Dao.CityRepository;
import ir.ac.kntu.Dao.impl.CityRepositoryImpl;
import ir.ac.kntu.base.services.impl.BaseServiceImpl;
import ir.ac.kntu.domains.City;
import ir.ac.kntu.services.CityService;

public class CityServiceImpl extends BaseServiceImpl<City, Long, CityRepository> implements CityService {
    public CityServiceImpl() {
        CityRepository repository = new CityRepositoryImpl();
        super.setRepository(repository);
    }

    public CityServiceImpl(CityRepository repository) {
        super(repository);
    }

    @Override
    public City findByName(String city) {
        return baseRepository.findByName(city);
    }

//    @Override
//    public List<Ticket> findByRoute(Route route) {
//        return baseRepository.findByRoute(route);
//    }
}
