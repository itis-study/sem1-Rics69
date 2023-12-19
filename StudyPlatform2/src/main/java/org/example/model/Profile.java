package org.example.model;

import java.util.UUID;

public class Profile {
    private UUID profileId;
    private String bio;
    private UUID userId;

    public Profile() {
    }

    public Profile(UUID profileId, String bio, UUID userId) {
        this.profileId = profileId;
        this.bio = bio;
        this.userId = userId;
    }

    public UUID getProfileId() {
        return profileId;
    }

    public String getBio() {
        return bio;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setProfileId(UUID profileId) {
        this.profileId = profileId;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
