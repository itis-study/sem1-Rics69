package org.example.DAO;

import org.example.model.Profile;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ProfileDAOImpl implements ProfileDAO{
    @Override
    public void addProfile(Profile profile) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO Profile (profile_id, bio, user_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, profile.getProfileId());
            statement.setString(2, profile.getBio());
            statement.setObject(3, profile.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Profile profile) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "UPDATE Profile SET bio = ? WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, profile.getBio());
            statement.setObject(2, profile.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProfile(Profile profile) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM Profile WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, profile.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Profile getProfileByUserId(UUID userId) {
        Profile profile = null;
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM Profile WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, userId, java.sql.Types.OTHER);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                profile = new Profile();
                profile.setProfileId(UUID.fromString(resultSet.getString("profile_id")));
                profile.setBio(resultSet.getString("bio"));
                profile.setUserId(UUID.fromString(resultSet.getString("user_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
