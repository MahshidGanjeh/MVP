package com.yaratech.mvptest.data.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class User {
    private int id;

    private String name;
    private String email;

    @ParcelConstructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
