package com.google.zxing;

/* JADX INFO: compiled from: Dimension.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14392b;

    public int a() {
        return this.f14392b;
    }

    public int b() {
        return this.f14391a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f14391a == aVar.f14391a && this.f14392b == aVar.f14392b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f14391a * 32713) + this.f14392b;
    }

    public String toString() {
        return this.f14391a + "x" + this.f14392b;
    }
}
