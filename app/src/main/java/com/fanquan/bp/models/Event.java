package com.fanquan.bp.models;

import java.io.Serializable;

public class Event implements Serializable {
    private String title;
    private String location;

    private String date;
    private String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //later on can add another constructor that receives date from unix time stamp

    public Event(String title, String location, String date, String time) {
        this.title = title;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
