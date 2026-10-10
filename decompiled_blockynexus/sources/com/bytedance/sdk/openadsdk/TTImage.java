package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes.dex */
public class TTImage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5614c;

    public TTImage(int i, int i2, String str) {
        this.f5612a = i;
        this.f5613b = i2;
        this.f5614c = str;
    }

    public int getHeight() {
        return this.f5612a;
    }

    public String getImageUrl() {
        return this.f5614c;
    }

    public int getWidth() {
        return this.f5613b;
    }

    public boolean isValid() {
        String str;
        return this.f5612a > 0 && this.f5613b > 0 && (str = this.f5614c) != null && str.length() > 0;
    }
}
