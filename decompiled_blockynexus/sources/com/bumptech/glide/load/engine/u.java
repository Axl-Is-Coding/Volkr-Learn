package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: EngineKey.java */
/* JADX INFO: loaded from: classes.dex */
class u implements com.bumptech.glide.load.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<?> f4611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f4612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.h f4613f;
    private final Map<Class<?>, com.bumptech.glide.load.o<?>> g;
    private final com.bumptech.glide.load.l h;
    private int i;

    u(Object obj, com.bumptech.glide.load.h hVar, int i, int i2, Map<Class<?>, com.bumptech.glide.load.o<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.l lVar) {
        com.bumptech.glide.e.l.a(obj);
        this.f4608a = obj;
        com.bumptech.glide.e.l.a(hVar, "Signature must not be null");
        this.f4613f = hVar;
        this.f4609b = i;
        this.f4610c = i2;
        com.bumptech.glide.e.l.a(map);
        this.g = map;
        com.bumptech.glide.e.l.a(cls, "Resource class must not be null");
        this.f4611d = cls;
        com.bumptech.glide.e.l.a(cls2, "Transcode class must not be null");
        this.f4612e = cls2;
        com.bumptech.glide.e.l.a(lVar);
        this.h = lVar;
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f4608a.equals(uVar.f4608a) && this.f4613f.equals(uVar.f4613f) && this.f4610c == uVar.f4610c && this.f4609b == uVar.f4609b && this.g.equals(uVar.g) && this.f4611d.equals(uVar.f4611d) && this.f4612e.equals(uVar.f4612e) && this.h.equals(uVar.h);
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        if (this.i == 0) {
            this.i = this.f4608a.hashCode();
            this.i = (this.i * 31) + this.f4613f.hashCode();
            this.i = (this.i * 31) + this.f4609b;
            this.i = (this.i * 31) + this.f4610c;
            this.i = (this.i * 31) + this.g.hashCode();
            this.i = (this.i * 31) + this.f4611d.hashCode();
            this.i = (this.i * 31) + this.f4612e.hashCode();
            this.i = (this.i * 31) + this.h.hashCode();
        }
        return this.i;
    }

    public String toString() {
        return "EngineKey{model=" + this.f4608a + ", width=" + this.f4609b + ", height=" + this.f4610c + ", resourceClass=" + this.f4611d + ", transcodeClass=" + this.f4612e + ", signature=" + this.f4613f + ", hashCode=" + this.i + ", transformations=" + this.g + ", options=" + this.h + '}';
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
