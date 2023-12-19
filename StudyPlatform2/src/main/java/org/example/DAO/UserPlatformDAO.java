package org.example.DAO;

import org.example.model.UserPlatform;

import java.util.List;
import java.util.UUID;

public interface UserPlatformDAO {
    public void addUser(UserPlatform user);
    public void deleteUser(UserPlatform user);
    public List<UserPlatform> getAllUsers();
    public UserPlatform getUserByLogin(String login);

    public UserPlatform getUserById(UUID userId);

    public void updateUser(UserPlatform user);
}
