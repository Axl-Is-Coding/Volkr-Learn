package cn.qqtheme.framework.entity;

/* JADX INFO: loaded from: classes.dex */
public class County extends Area implements LinkageThird {
    private String cityId;

    public County() {
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String str) {
        this.cityId = str;
    }

    public County(String str) {
        super(str);
    }

    public County(String str, String str2) {
        super(str, str2);
    }
}
