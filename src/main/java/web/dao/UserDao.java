package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> allUsers();
    User showUser(int id);
    void saveUser(User user);
    void updateUser(User editedUser);
    void deleteUser(int id);
}
