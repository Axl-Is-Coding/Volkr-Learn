package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.InterfaceC0497g;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: ResourceCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class D implements InterfaceC0497g, d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0497g.a f4414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0498h<?> f4415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4417d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.h f4418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.a.u<File, ?>> f4419f;
    private int g;
    private volatile u.a<?> h;
    private File i;
    private E j;

    D(C0498h<?> c0498h, InterfaceC0497g.a aVar) {
        this.f4415b = c0498h;
        this.f4414a = aVar;
    }

    private boolean b() {
        return this.g < this.f4419f.size();
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g
    public boolean a() {
        List<com.bumptech.glide.load.h> listC = this.f4415b.c();
        boolean z = false;
        if (listC.isEmpty()) {
            return false;
        }
        List<Class<?>> listK = this.f4415b.k();
        if (listK.isEmpty()) {
            if (File.class.equals(this.f4415b.m())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f4415b.h() + " to " + this.f4415b.m());
        }
        while (true) {
            if (this.f4419f != null && b()) {
                this.h = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.a.u<File, ?>> list = this.f4419f;
                    int i = this.g;
                    this.g = i + 1;
                    this.h = list.get(i).buildLoadData(this.i, this.f4415b.n(), this.f4415b.f(), this.f4415b.i());
                    if (this.h != null && this.f4415b.c(this.h.f4298c.a())) {
                        this.h.f4298c.a(this.f4415b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f4417d++;
            if (this.f4417d >= listK.size()) {
                this.f4416c++;
                if (this.f4416c >= listC.size()) {
                    return false;
                }
                this.f4417d = 0;
            }
            com.bumptech.glide.load.h hVar = listC.get(this.f4416c);
            Class<?> cls = listK.get(this.f4417d);
            this.j = new E(this.f4415b.b(), hVar, this.f4415b.l(), this.f4415b.n(), this.f4415b.f(), this.f4415b.b(cls), cls, this.f4415b.i());
            this.i = this.f4415b.d().a(this.j);
            File file = this.i;
            if (file != null) {
                this.f4418e = hVar;
                this.f4419f = this.f4415b.a(file);
                this.g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g
    public void cancel() {
        u.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.f4298c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Object obj) {
        this.f4414a.a(this.f4418e, obj, this.h.f4298c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Exception exc) {
        this.f4414a.a(this.j, exc, this.h.f4298c, DataSource.RESOURCE_DISK_CACHE);
    }
}
