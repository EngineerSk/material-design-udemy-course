package com.engineersk.recyclerview;

public class User {
    private String mUsername;
    private String mUserDescription;
    private int userImageId;

    public User(String username, String userDescription, int userImageId) {
        mUsername = username;
        mUserDescription = userDescription;
        this.userImageId = userImageId;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getUserDescription() {
        return mUserDescription;
    }

    public int getUserImageId() {
        return userImageId;
    }
}
