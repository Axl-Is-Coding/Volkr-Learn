package com.tendcloud.tenddata;

import java.io.Serializable;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class j implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f20024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f20025b;

    public String a() {
        return this.f20024a;
    }

    public String b() {
        return this.f20025b;
    }

    public void setActivities(String str) {
        this.f20024a = str;
    }

    public void setHandHolding(String str) {
        this.f20025b = str;
    }
}
