package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: compiled from: FieldValueMetaData.java */
/* JADX INFO: loaded from: classes5.dex */
public class bp implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f20723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f20724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20726d;

    public bp(byte b2, boolean z) {
        this.f20724b = b2;
        this.f20723a = false;
        this.f20725c = null;
        this.f20726d = z;
    }

    public boolean a() {
        return this.f20723a;
    }

    public String b() {
        return this.f20725c;
    }

    public boolean c() {
        return this.f20724b == 12;
    }

    public boolean d() {
        byte b2 = this.f20724b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    public boolean e() {
        return this.f20726d;
    }

    public bp(byte b2) {
        this(b2, false);
    }

    public bp(byte b2, String str) {
        this.f20724b = b2;
        this.f20723a = true;
        this.f20725c = str;
        this.f20726d = false;
    }
}
