package com.google.android.datatransport.runtime;

import java.util.Arrays;

/* JADX INFO: compiled from: EncodedPayload.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.datatransport.b f12953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f12954b;

    public k(com.google.android.datatransport.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f12953a = bVar;
        this.f12954b = bArr;
    }

    public byte[] a() {
        return this.f12954b;
    }

    public com.google.android.datatransport.b b() {
        return this.f12953a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f12953a.equals(kVar.f12953a)) {
            return Arrays.equals(this.f12954b, kVar.f12954b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f12953a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12954b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f12953a + ", bytes=[...]}";
    }
}
