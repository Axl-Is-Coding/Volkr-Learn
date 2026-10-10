package com.bumptech.glide.d;

import com.bumptech.glide.e.l;
import com.bumptech.glide.load.h;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ObjectKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4141a;

    public d(Object obj) {
        l.a(obj);
        this.f4141a = obj;
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f4141a.equals(((d) obj).f4141a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        return this.f4141a.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f4141a + '}';
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f4141a.toString().getBytes(h.f4628a));
    }
}
