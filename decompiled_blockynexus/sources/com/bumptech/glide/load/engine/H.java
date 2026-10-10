package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.engine.InterfaceC0497g;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class H implements InterfaceC0497g.a, InterfaceC0497g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0498h<?> f4459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0497g.a f4460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0494d f4462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f4463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile u.a<?> f4464f;
    private C0495e g;

    H(C0498h<?> c0498h, InterfaceC0497g.a aVar) {
        this.f4459a = c0498h;
        this.f4460b = aVar;
    }

    private void b(u.a<?> aVar) {
        this.f4464f.f4298c.a(this.f4459a.j(), new G(this, aVar));
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g
    public boolean a() {
        Object obj = this.f4463e;
        if (obj != null) {
            this.f4463e = null;
            a(obj);
        }
        C0494d c0494d = this.f4462d;
        if (c0494d != null && c0494d.a()) {
            return true;
        }
        this.f4462d = null;
        this.f4464f = null;
        boolean z = false;
        while (!z && b()) {
            List<u.a<?>> listG = this.f4459a.g();
            int i = this.f4461c;
            this.f4461c = i + 1;
            this.f4464f = listG.get(i);
            if (this.f4464f != null && (this.f4459a.e().a(this.f4464f.f4298c.c()) || this.f4459a.c(this.f4464f.f4298c.a()))) {
                b(this.f4464f);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g
    public void cancel() {
        u.a<?> aVar = this.f4464f;
        if (aVar != null) {
            aVar.f4298c.cancel();
        }
    }

    private boolean b() {
        return this.f4461c < this.f4459a.g().size();
    }

    boolean a(u.a<?> aVar) {
        u.a<?> aVar2 = this.f4464f;
        return aVar2 != null && aVar2 == aVar;
    }

    private void a(Object obj) {
        long jA = com.bumptech.glide.e.h.a();
        try {
            com.bumptech.glide.load.a<X> aVarA = this.f4459a.a(obj);
            C0496f c0496f = new C0496f(aVarA, obj, this.f4459a.i());
            this.g = new C0495e(this.f4464f.f4296a, this.f4459a.l());
            this.f4459a.d().a(this.g, c0496f);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.g + ", data: " + obj + ", encoder: " + aVarA + ", duration: " + com.bumptech.glide.e.h.a(jA));
            }
            this.f4464f.f4298c.b();
            this.f4462d = new C0494d(Collections.singletonList(this.f4464f.f4296a), this.f4459a, this);
        } catch (Throwable th) {
            this.f4464f.f4298c.b();
            throw th;
        }
    }

    void a(u.a<?> aVar, Object obj) {
        p pVarE = this.f4459a.e();
        if (obj != null && pVarE.a(aVar.f4298c.c())) {
            this.f4463e = obj;
            this.f4460b.c();
        } else {
            InterfaceC0497g.a aVar2 = this.f4460b;
            com.bumptech.glide.load.h hVar = aVar.f4296a;
            com.bumptech.glide.load.data.d<?> dVar = aVar.f4298c;
            aVar2.a(hVar, obj, dVar, dVar.c(), this.g);
        }
    }

    void a(u.a<?> aVar, Exception exc) {
        InterfaceC0497g.a aVar2 = this.f4460b;
        C0495e c0495e = this.g;
        com.bumptech.glide.load.data.d<?> dVar = aVar.f4298c;
        aVar2.a(c0495e, exc, dVar, dVar.c());
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g.a
    public void a(com.bumptech.glide.load.h hVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.h hVar2) {
        this.f4460b.a(hVar, obj, dVar, this.f4464f.f4298c.c(), hVar);
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g.a
    public void a(com.bumptech.glide.load.h hVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        this.f4460b.a(hVar, exc, dVar, this.f4464f.f4298c.c());
    }
}
