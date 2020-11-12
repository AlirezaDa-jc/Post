/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.Dao;

import ir.ac.kntu.base.repository.BaseRepository;
import ir.ac.kntu.domains.User;

public interface UserRepository extends BaseRepository<User, Long> {
    User findByUserName(String userName);

    User userLogin(String userName, String password);
}
