package com.sandboxol.common.entity;

/* JADX INFO: loaded from: classes3.dex */
public class S3Image {
    private final String imageUrl;

    public S3Image(String str) {
        this.imageUrl = str;
    }

    public String getImageId() {
        if (!this.imageUrl.contains("?")) {
            return this.imageUrl;
        }
        String str = this.imageUrl;
        return str.substring(0, str.lastIndexOf("?"));
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
}
