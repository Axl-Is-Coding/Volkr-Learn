package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class Header {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5457b;

    public Header(String str, String str2) {
        this.f5456a = str;
        this.f5457b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Header.class != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        return TextUtils.equals(this.f5456a, header.f5456a) && TextUtils.equals(this.f5457b, header.f5457b);
    }

    public final String getName() {
        return this.f5456a;
    }

    public final String getValue() {
        return this.f5457b;
    }

    public int hashCode() {
        return (this.f5456a.hashCode() * 31) + this.f5457b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f5456a + ",value=" + this.f5457b + "]";
    }
}
