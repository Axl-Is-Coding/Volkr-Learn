package com.bumptech.glide.load;

import java.security.MessageDigest;

/* JADX INFO: compiled from: Options.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.a.b<k<?>, Object> f4635a = new com.bumptech.glide.e.b();

    public void a(l lVar) {
        this.f4635a.a((a.a.i<? extends k<?>, ? extends Object>) lVar.f4635a);
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return this.f4635a.equals(((l) obj).f4635a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        return this.f4635a.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f4635a + '}';
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i = 0; i < this.f4635a.size(); i++) {
            a(this.f4635a.b(i), this.f4635a.d(i), messageDigest);
        }
    }

    public <T> l a(k<T> kVar, T t) {
        this.f4635a.put(kVar, t);
        return this;
    }

    public <T> T a(k<T> kVar) {
        return this.f4635a.containsKey(kVar) ? (T) this.f4635a.get(kVar) : kVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(k<T> kVar, Object obj, MessageDigest messageDigest) {
        kVar.a(obj, messageDigest);
    }
}
