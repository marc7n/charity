package pl.coderslab.charity.security;

import pl.coderslab.charity.entity.User;


public interface UserService {
    User findByUsername(String username);

    void addUser(User user);

    User findByEmail(String email);

    boolean existsByName(String username);

    boolean existsByEmail(String email);
}