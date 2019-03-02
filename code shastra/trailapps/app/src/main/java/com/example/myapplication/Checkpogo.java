package com.example.myapplication;

public class Checkpogo {
    private String Id;
    private String Approved;
    private String Applied;

    public Checkpogo(String Id, String approved, String applied) {
        this.Id = Id;
        Approved = approved;
        Applied = applied;
    }

    public String getID() {
        return Id;
    }

    public void setID(String Id) {
        this.Id = Id;
    }

    public String getApproved() {
        return Approved;
    }

    public void setApproved(String approved) {
        Approved = approved;
    }

    public String getApplied() {
        return Applied;
    }

    public void setApplied(String applied) {
        Applied = applied;
    }
}
