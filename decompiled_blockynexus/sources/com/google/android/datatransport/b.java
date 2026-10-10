package com.google.android.datatransport;

/* JADX INFO: compiled from: Encoding.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12723a;

    private b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f12723a = str;
    }

    public static b a(String str) {
        return new b(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f12723a.equals(((b) obj).f12723a);
        }
        return false;
    }

    public int hashCode() {
        return this.f12723a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f12723a + "\"}";
    }

    public String a() {
        return this.f12723a;
    }
}
