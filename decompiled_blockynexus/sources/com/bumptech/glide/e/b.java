package com.bumptech.glide.e;

/* JADX INFO: compiled from: CachedHashCodeArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<K, V> extends a.a.b<K, V> {
    private int i;

    @Override // a.a.i
    public V a(int i, V v) {
        this.i = 0;
        return (V) super.a(i, v);
    }

    @Override // a.a.i
    public V c(int i) {
        this.i = 0;
        return (V) super.c(i);
    }

    @Override // a.a.i, java.util.Map
    public void clear() {
        this.i = 0;
        super.clear();
    }

    @Override // a.a.i, java.util.Map
    public int hashCode() {
        if (this.i == 0) {
            this.i = super.hashCode();
        }
        return this.i;
    }

    @Override // a.a.i, java.util.Map
    public V put(K k, V v) {
        this.i = 0;
        return (V) super.put(k, v);
    }

    @Override // a.a.i
    public void a(a.a.i<? extends K, ? extends V> iVar) {
        this.i = 0;
        super.a((a.a.i) iVar);
    }
}
