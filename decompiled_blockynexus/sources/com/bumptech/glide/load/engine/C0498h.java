package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.engine.DecodeJob;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DecodeHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class C0498h<Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<u.a<?>> f4567a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.h> f4568b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.f f4569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f4570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4572f;
    private Class<?> g;
    private DecodeJob.d h;
    private com.bumptech.glide.load.l i;
    private Map<Class<?>, com.bumptech.glide.load.o<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private com.bumptech.glide.load.h n;
    private Priority o;
    private p p;
    private boolean q;
    private boolean r;

    C0498h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void a(com.bumptech.glide.f fVar, Object obj, com.bumptech.glide.load.h hVar, int i, int i2, p pVar, Class<?> cls, Class<R> cls2, Priority priority, com.bumptech.glide.load.l lVar, Map<Class<?>, com.bumptech.glide.load.o<?>> map, boolean z, boolean z2, DecodeJob.d dVar) {
        this.f4569c = fVar;
        this.f4570d = obj;
        this.n = hVar;
        this.f4571e = i;
        this.f4572f = i2;
        this.p = pVar;
        this.g = cls;
        this.h = dVar;
        this.k = cls2;
        this.o = priority;
        this.i = lVar;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    com.bumptech.glide.load.engine.a.b b() {
        return this.f4569c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean c(Class<?> cls) {
        return a((Class) cls) != null;
    }

    com.bumptech.glide.load.engine.b.a d() {
        return this.h.a();
    }

    p e() {
        return this.p;
    }

    int f() {
        return this.f4572f;
    }

    List<u.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.f4567a.clear();
            List listA = this.f4569c.f().a(this.f4570d);
            int size = listA.size();
            for (int i = 0; i < size; i++) {
                u.a<?> aVarBuildLoadData = ((com.bumptech.glide.load.a.u) listA.get(i)).buildLoadData(this.f4570d, this.f4571e, this.f4572f, this.i);
                if (aVarBuildLoadData != null) {
                    this.f4567a.add(aVarBuildLoadData);
                }
            }
        }
        return this.f4567a;
    }

    Class<?> h() {
        return this.f4570d.getClass();
    }

    com.bumptech.glide.load.l i() {
        return this.i;
    }

    Priority j() {
        return this.o;
    }

    List<Class<?>> k() {
        return this.f4569c.f().b(this.f4570d.getClass(), this.g, this.k);
    }

    com.bumptech.glide.load.h l() {
        return this.n;
    }

    Class<?> m() {
        return this.k;
    }

    int n() {
        return this.f4571e;
    }

    boolean o() {
        return this.r;
    }

    <Z> com.bumptech.glide.load.o<Z> b(Class<Z> cls) {
        com.bumptech.glide.load.o<Z> oVar = (com.bumptech.glide.load.o) this.j.get(cls);
        if (oVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.o<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.o<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    oVar = (com.bumptech.glide.load.o) next.getValue();
                    break;
                }
            }
        }
        if (oVar != null) {
            return oVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return com.bumptech.glide.load.b.e.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    List<com.bumptech.glide.load.h> c() {
        if (!this.m) {
            this.m = true;
            this.f4568b.clear();
            List<u.a<?>> listG = g();
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                u.a<?> aVar = listG.get(i);
                if (!this.f4568b.contains(aVar.f4296a)) {
                    this.f4568b.add(aVar.f4296a);
                }
                for (int i2 = 0; i2 < aVar.f4297b.size(); i2++) {
                    if (!this.f4568b.contains(aVar.f4297b.get(i2))) {
                        this.f4568b.add(aVar.f4297b.get(i2));
                    }
                }
            }
        }
        return this.f4568b;
    }

    boolean b(C<?> c2) {
        return this.f4569c.f().b(c2);
    }

    void a() {
        this.f4569c = null;
        this.f4570d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f4567a.clear();
        this.l = false;
        this.f4568b.clear();
        this.m = false;
    }

    <Data> z<Data, ?, Transcode> a(Class<Data> cls) {
        return this.f4569c.f().a(cls, this.g, this.k);
    }

    <Z> com.bumptech.glide.load.n<Z> a(C<Z> c2) {
        return this.f4569c.f().a((C) c2);
    }

    List<com.bumptech.glide.load.a.u<File, ?>> a(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f4569c.f().a(file);
    }

    boolean a(com.bumptech.glide.load.h hVar) {
        List<u.a<?>> listG = g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (listG.get(i).f4296a.equals(hVar)) {
                return true;
            }
        }
        return false;
    }

    <X> com.bumptech.glide.load.a<X> a(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f4569c.f().c(x);
    }
}
