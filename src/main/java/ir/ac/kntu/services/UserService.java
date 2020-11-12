/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.services;

import ir.ac.kntu.base.services.BaseService;
import ir.ac.kntu.domains.User;

import javax.servlet.ServletOutputStream;

public interface UserService extends BaseService<User, Long> {
    boolean login(String userName, String password);

    boolean signIn(String userName, String password);

    void edit(ServletOutputStream servletOutputStream, String... fields);

    User findByUserName(String userName);
}
