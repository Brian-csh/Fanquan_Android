package com.fanquan.bp.models;

import java.io.Serializable;

public class Topic implements Serializable {
    private String title;
    private String category;

    public String getTitle() {
        return title;
    }

    public Topic(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
