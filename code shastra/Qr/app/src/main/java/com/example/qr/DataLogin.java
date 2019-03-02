package com.example.qr;

public class DataLogin {
    private String dest;
    private String name;
    private String password;

    public DataLogin() {
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataLogin(String dest, String name, String password) {
        this.dest = dest;
        this.name = name;
        this.password = password;
    }
}
