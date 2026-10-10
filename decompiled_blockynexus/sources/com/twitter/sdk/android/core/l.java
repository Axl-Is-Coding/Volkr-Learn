package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.b;

/* JADX INFO: compiled from: Session.java */
/* JADX INFO: loaded from: classes5.dex */
public class l<T extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.a.c("auth_token")
    private final T f20219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.a.c("id")
    private final long f20220b;

    public l(T t, long j) {
        if (t == null) {
            throw new IllegalArgumentException("AuthToken must not be null.");
        }
        this.f20219a = t;
        this.f20220b = j;
    }

    public T a() {
        return this.f20219a;
    }

    public long b() {
        return this.f20220b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f20220b != lVar.f20220b) {
            return false;
        }
        T t = this.f20219a;
        return t != null ? t.equals(lVar.f20219a) : lVar.f20219a == null;
    }

    public int hashCode() {
        T t = this.f20219a;
        int iHashCode = t != null ? t.hashCode() : 0;
        long j = this.f20220b;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
