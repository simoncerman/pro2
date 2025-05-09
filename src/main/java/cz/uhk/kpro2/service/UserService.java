package cz.uhk.kpro2.service;

import cz.uhk.kpro2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUser(long id);
    void saveUser(User user);
    void deleteUser(long id);
}
