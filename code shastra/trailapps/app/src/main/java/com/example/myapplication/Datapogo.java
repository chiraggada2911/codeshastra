package com.example.myapplication;

public class Datapogo {
    private String clg;
    private String clgId;
    private String clgstn;
    private String source;
    private String name;
    private String password;

    public Datapogo() {
    }

    public String getClg() {
        return clg;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }

    public String getClgId() {
        return clgId;
    }

    public void setClgId(String clgId) {
        this.clgId = clgId;
    }

    public String getClgstn() {
        return clgstn;
    }

    public void setClgstn(String clgstn) {
        this.clgstn = clgstn;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public Datapogo(String clg, String clgId, String clgstn, String source, String name, String password) {
        this.clg = clg;
        this.clgId = clgId;
        this.clgstn = clgstn;
        this.source = source;
        this.name = name;
        this.password = password;
    }
}
