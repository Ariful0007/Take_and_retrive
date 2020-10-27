package com.example.take_and_retrive;

public class ModelUser {
    String uid,name;

    public ModelUser() {
    }

    public ModelUser(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }
}
