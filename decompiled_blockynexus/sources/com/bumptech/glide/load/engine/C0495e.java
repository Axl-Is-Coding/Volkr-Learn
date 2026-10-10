package com.bumptech.glide.load.engine;

import java.security.MessageDigest;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DataCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
final class C0495e implements com.bumptech.glide.load.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.h f4562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.h f4563b;

    C0495e(com.bumptech.glide.load.h hVar, com.bumptech.glide.load.h hVar2) {
        this.f4562a = hVar;
        this.f4563b = hVar2;
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (!(obj instanceof C0495e)) {
            return false;
        }
        C0495e c0495e = (C0495e) obj;
        return this.f4562a.equals(c0495e.f4562a) && this.f4563b.equals(c0495e.f4563b);
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        return (this.f4562a.hashCode() * 31) + this.f4563b.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f4562a + ", signature=" + this.f4563b + '}';
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f4562a.updateDiskCacheKey(messageDigest);
        this.f4563b.updateDiskCacheKey(messageDigest);
    }
}
