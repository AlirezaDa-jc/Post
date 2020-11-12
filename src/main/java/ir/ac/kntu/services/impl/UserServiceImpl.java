package ir.ac.kntu.services.impl;

import ir.ac.kntu.Dao.UserRepository;
import ir.ac.kntu.Dao.impl.UserRepositoryImpl;
import ir.ac.kntu.base.services.impl.BaseServiceImpl;
import ir.ac.kntu.domains.User;
import ir.ac.kntu.services.UserService;

import javax.servlet.ServletOutputStream;
import java.io.IOException;


public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {
    private static User user = new User();

    public UserServiceImpl() {
        UserRepository repository = new UserRepositoryImpl();
        super.setRepository(repository);
    }

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserServiceImpl.user = user;
    }

    @Override
    public boolean login(String userName, String password) {
        user = baseRepository.userLogin(userName, password);
        return user != null;
    }

    @Override
    public boolean signIn(String userName, String password) {
        try {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            baseRepository.saveOrUpdate(user);
            setUser(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    @Override
    public void edit(ServletOutputStream out, String... fields) {
        try {
            if (!(fields[1] == null || fields[1].equals("null"))) {
                updateUserName(fields[1], out);
            }
            if (!(fields[2] == null || fields[2].equals("null") &&
                    !(fields[3] == null || fields[3].equals("null") &&
                            !(fields[4] == null || fields[4].equals("null"))))) {
                updatePassword(fields[2], fields[3], fields[4], out);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User findByUserName(String userName) {
        return baseRepository.findByUserName(userName);
    }

    private void updatePassword(String currentPassword, String password, String confirmationPassword, ServletOutputStream out) throws IOException {
        if (!confirmationPassword.equals(password)) {
            out.println("Wrong Password");
            return;
        }
        if (!currentPassword.equals(user.getPassword())) {
            out.println("Wrong Password");
            return;
        }
        user.setPassword(password);
        saveOrUpdate(user);
        out.println("Password Changed Successfully!");
    }

    private void updateUserName(String userName, ServletOutputStream out) throws IOException {
        user.setUserName(userName);
        try {
            saveOrUpdate(user);
        } catch (Exception ex) {
            out.println("Duplicate User Name!!!!");
        }
        out.println("UserName Changed Successfully!");
    }

}
