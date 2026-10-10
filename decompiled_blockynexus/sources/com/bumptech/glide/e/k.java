package com.bumptech.glide.e;

/* JADX INFO: compiled from: MultiClassKey.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f4173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f4174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Class<?> f4175c;

    public k() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f4173a = cls;
        this.f4174b = cls2;
        this.f4175c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f4173a.equals(kVar.f4173a) && this.f4174b.equals(kVar.f4174b) && n.b(this.f4175c, kVar.f4175c);
    }

    public int hashCode() {
        int iHashCode = ((this.f4173a.hashCode() * 31) + this.f4174b.hashCode()) * 31;
        Class<?> cls = this.f4175c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f4173a + ", second=" + this.f4174b + '}';
    }

    public k(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
