package guru.springframework.blog.service;
import guru.springframework.blog.domain.User;

/**
 * Created by Simanta.Sarma on 26-09-2017.
 */
public interface UserService {
    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);
}
