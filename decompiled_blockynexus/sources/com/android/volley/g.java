package com.android.volley;

import android.text.TextUtils;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4003b;

    public g(String str, String str2) {
        this.f4002a = str;
        this.f4003b = str2;
    }

    public final String a() {
        return this.f4002a;
    }

    public final String b() {
        return this.f4003b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.f4002a, gVar.f4002a) && TextUtils.equals(this.f4003b, gVar.f4003b);
    }

    public int hashCode() {
        return (this.f4002a.hashCode() * 31) + this.f4003b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f4002a + ",value=" + this.f4003b + "]";
    }
}
