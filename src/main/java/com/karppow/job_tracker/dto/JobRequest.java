package com.karppow.job_tracker.dto;


public class JobRequest {

    private String company;
    private String position;

public JobRequest(String company, String position){
    this.company = company;
    this.position = position;
}

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
