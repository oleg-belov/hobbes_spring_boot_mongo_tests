package guru.springframework.blog.service;

import guru.springframework.blog.domain.User;
import guru.springframework.blog.repositories.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMongoRepository repository;

    @Override
    public Iterable<User> listAllUsers() {
       return repository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.delete(id);

    }
}
