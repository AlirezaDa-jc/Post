/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.services;

import ir.ac.kntu.base.services.BaseService;
import ir.ac.kntu.domains.City;

public interface CityService extends BaseService<City, Long> {

    City findByName(String city);
}
