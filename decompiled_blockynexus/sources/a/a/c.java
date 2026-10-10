package a.a;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: ArraySet.java */
/* JADX INFO: loaded from: classes.dex */
class c<E> extends h<E, E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f129d;

    c(d dVar) {
        this.f129d = dVar;
    }

    @Override // a.a.h
    protected Object a(int i, int i2) {
        return this.f129d.h[i];
    }

    @Override // a.a.h
    protected int b(Object obj) {
        return this.f129d.indexOf(obj);
    }

    @Override // a.a.h
    protected int c() {
        return this.f129d.i;
    }

    @Override // a.a.h
    protected int a(Object obj) {
        return this.f129d.indexOf(obj);
    }

    @Override // a.a.h
    protected Map<E, E> b() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // a.a.h
    protected void a(E e2, E e3) {
        this.f129d.add(e2);
    }

    @Override // a.a.h
    protected E a(int i, E e2) {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // a.a.h
    protected void a(int i) {
        this.f129d.d(i);
    }

    @Override // a.a.h
    protected void a() {
        this.f129d.clear();
    }
}
