package com.bumptech.glide.load.engine;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ResourceCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
final class E implements com.bumptech.glide.load.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bumptech.glide.e.i<Class<?>, byte[]> f4434a = new com.bumptech.glide.e.i<>(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.h f4436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.h f4437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f4439f;
    private final Class<?> g;
    private final com.bumptech.glide.load.l h;
    private final com.bumptech.glide.load.o<?> i;

    E(com.bumptech.glide.load.engine.a.b bVar, com.bumptech.glide.load.h hVar, com.bumptech.glide.load.h hVar2, int i, int i2, com.bumptech.glide.load.o<?> oVar, Class<?> cls, com.bumptech.glide.load.l lVar) {
        this.f4435b = bVar;
        this.f4436c = hVar;
        this.f4437d = hVar2;
        this.f4438e = i;
        this.f4439f = i2;
        this.i = oVar;
        this.g = cls;
        this.h = lVar;
    }

    private byte[] a() {
        byte[] bArrA = f4434a.a(this.g);
        if (bArrA != null) {
            return bArrA;
        }
        byte[] bytes = this.g.getName().getBytes(com.bumptech.glide.load.h.f4628a);
        f4434a.b(this.g, bytes);
        return bytes;
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (!(obj instanceof E)) {
            return false;
        }
        E e2 = (E) obj;
        return this.f4439f == e2.f4439f && this.f4438e == e2.f4438e && com.bumptech.glide.e.n.b(this.i, e2.i) && this.g.equals(e2.g) && this.f4436c.equals(e2.f4436c) && this.f4437d.equals(e2.f4437d) && this.h.equals(e2.h);
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        int iHashCode = (((((this.f4436c.hashCode() * 31) + this.f4437d.hashCode()) * 31) + this.f4438e) * 31) + this.f4439f;
        com.bumptech.glide.load.o<?> oVar = this.i;
        if (oVar != null) {
            iHashCode = (iHashCode * 31) + oVar.hashCode();
        }
        return (((iHashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f4436c + ", signature=" + this.f4437d + ", width=" + this.f4438e + ", height=" + this.f4439f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + '}';
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f4435b.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f4438e).putInt(this.f4439f).array();
        this.f4437d.updateDiskCacheKey(messageDigest);
        this.f4436c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.o<?> oVar = this.i;
        if (oVar != null) {
            oVar.updateDiskCacheKey(messageDigest);
        }
        this.h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f4435b.put(bArr);
    }
}
