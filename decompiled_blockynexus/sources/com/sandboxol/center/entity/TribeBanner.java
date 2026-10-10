package com.sandboxol.center.entity;

import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes3.dex */
public class TribeBanner {
    private String image;
    private String image_zh;
    private String title;
    private String title_zh;

    public String getImage() {
        return (this.image_zh == null || !CommonHelper.getCountry().equals("CN")) ? this.image : this.image_zh;
    }

    public String getTitle() {
        return (this.title_zh == null || !CommonHelper.getCountry().equals("CN")) ? this.title : this.title_zh;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
