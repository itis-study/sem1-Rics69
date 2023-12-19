package org.example.DAO;

import org.example.model.UserPlatform;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserPlatformDAOImpl implements UserPlatformDAO{
    @Override
    public void addUser(UserPlatform user) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO UserPlatform (user_id, login, first_name, last_name, password, user_type) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, user.getUserId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getUserType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(UserPlatform user) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM UserPlatform WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserPlatform> getAllUsers() {
        List<UserPlatform> users = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM User";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserPlatform user = new UserPlatform();
                user.setUserId(UUID.fromString(resultSet.getString("user_id")));
                user.setLogin(resultSet.getString("login"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(resultSet.getString("user_type"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserPlatform getUserByLogin(String login) {
        UserPlatform user = null;
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM UserPlatform WHERE login = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new UserPlatform();
                user.setUserId(UUID.fromString(resultSet.getString("user_id")));
                user.setLogin(resultSet.getString("login"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(resultSet.getString("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public UserPlatform getUserById(UUID userId) {
        UserPlatform user = null;
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM UserPlatform WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, userId, java.sql.Types.OTHER);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new UserPlatform();
                user.setUserId(UUID.fromString(resultSet.getString("user_id")));
                user.setLogin(resultSet.getString("login"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(resultSet.getString("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(UserPlatform user) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "UPDATE UserPlatform SET login = ?, first_name = ?, last_name = ?, password = ?, user_type = ? WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getUserType());
            statement.setObject(6, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
