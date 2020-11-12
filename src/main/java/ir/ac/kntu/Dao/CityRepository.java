package ir.ac.kntu.Dao;

import ir.ac.kntu.base.repository.BaseRepository;
import ir.ac.kntu.domains.City;

public interface CityRepository extends BaseRepository<City, Long> {
    City findByName(String city);
}
