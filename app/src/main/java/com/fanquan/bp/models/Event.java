package com.fanquan.bp.models;

import java.io.Serializable;

public class Event implements Serializable {
    private String title;
    private String details;
    //@todo add description, then separate time and location

    public Event() {
    }

    public Event(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
