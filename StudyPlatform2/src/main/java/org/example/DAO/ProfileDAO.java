package org.example.DAO;

import org.example.model.Profile;

import java.util.UUID;

public interface ProfileDAO {
    public void addProfile(Profile profile);
    public void updateProfile(Profile profile);
    public void deleteProfile(Profile profile);
    public Profile getProfileByUserId(UUID userId);
}
