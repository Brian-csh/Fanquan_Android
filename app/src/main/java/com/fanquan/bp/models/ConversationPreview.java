package com.fanquan.bp.models;

public class ConversationPreview {
    private String imageUrl;
    private String name;
    private String lastMsg;

    public ConversationPreview(String imageUrl, String name, String lastMsg) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.lastMsg = lastMsg;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }
}
