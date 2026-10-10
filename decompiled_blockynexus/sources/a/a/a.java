package a.a;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: ArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
class a<K, V> extends h<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f128d;

    a(b bVar) {
        this.f128d = bVar;
    }

    @Override // a.a.h
    protected Object a(int i, int i2) {
        return this.f128d.f164f[(i << 1) + i2];
    }

    @Override // a.a.h
    protected int b(Object obj) {
        return this.f128d.b(obj);
    }

    @Override // a.a.h
    protected int c() {
        return this.f128d.g;
    }

    @Override // a.a.h
    protected int a(Object obj) {
        return this.f128d.a(obj);
    }

    @Override // a.a.h
    protected Map<K, V> b() {
        return this.f128d;
    }

    @Override // a.a.h
    protected void a(K k, V v) {
        this.f128d.put(k, v);
    }

    @Override // a.a.h
    protected V a(int i, V v) {
        return this.f128d.a(i, v);
    }

    @Override // a.a.h
    protected void a(int i) {
        this.f128d.c(i);
    }

    @Override // a.a.h
    protected void a() {
        this.f128d.clear();
    }
}
