package org.aplusstudios.com.biologytrivia.model;

public class User {

    private int avatar_drawable_id;
    private String userNickName;
    private int level;

    public User(int avatar_drawable_id, String userNickName, int level) {
        this.avatar_drawable_id = avatar_drawable_id;
        this.userNickName = userNickName;
        this.level = level;
    }

    public int getAvatar_drawable_id() {
        return avatar_drawable_id;
    }

    public void setAvatar_drawable_id(int avatar_drawable_id) {
        this.avatar_drawable_id = avatar_drawable_id;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
