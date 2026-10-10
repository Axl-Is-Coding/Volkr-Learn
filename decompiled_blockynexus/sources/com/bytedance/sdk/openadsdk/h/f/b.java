package com.bytedance.sdk.openadsdk.h.f;

import java.io.Serializable;

/* JADX INFO: compiled from: VideoUrlModel.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6931b = 204800;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6932c;

    public b a(String str) {
        this.f6930a = str;
        return this;
    }

    public b b(String str) {
        this.f6932c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f6930a + "', maxPreloadSize=" + this.f6931b + ", fileNameKey='" + this.f6932c + "'}";
    }

    public b a(int i) {
        if (i > 0) {
            this.f6931b = i;
        }
        return this;
    }
}
