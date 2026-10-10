package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.InterfaceC0497g;
import java.io.File;
import java.util.List;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DataCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class C0494d implements InterfaceC0497g, d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.load.h> f4556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0498h<?> f4557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC0497g.a f4558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.h f4560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.a.u<File, ?>> f4561f;
    private int g;
    private volatile u.a<?> h;
    private File i;

    C0494d(C0498h<?> c0498h, InterfaceC0497g.a aVar) {
        this(c0498h.c(), c0498h, aVar);
    }

    private boolean b() {
        return this.g < this.f4561f.size();
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f4561f != null && b()) {
                this.h = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.a.u<File, ?>> list = this.f4561f;
                    int i = this.g;
                    this.g = i + 1;
                    this.h = list.get(i).buildLoadData(this.i, this.f4557b.n(), this.f4557b.f(), this.f4557b.i());
                    if (this.h != null && this.f4557b.c(this.h.f4298c.a())) {
                        this.h.f4298c.a(this.f4557b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f4559d++;
            if (this.f4559d >= this.f4556a.size()) {
                return false;
            }
            com.bumptech.glide.load.h hVar = this.f4556a.get(this.f4559d);
            this.i = this.f4557b.d().a(new C0495e(hVar, this.f4557b.l()));
            File file = this.i;
            if (file != null) {
                this.f4560e = hVar;
                this.f4561f = this.f4557b.a(file);
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

    C0494d(List<com.bumptech.glide.load.h> list, C0498h<?> c0498h, InterfaceC0497g.a aVar) {
        this.f4559d = -1;
        this.f4556a = list;
        this.f4557b = c0498h;
        this.f4558c = aVar;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Object obj) {
        this.f4558c.a(this.f4560e, obj, this.h.f4298c, DataSource.DATA_DISK_CACHE, this.f4560e);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Exception exc) {
        this.f4558c.a(this.f4560e, exc, this.h.f4298c, DataSource.DATA_DISK_CACHE);
    }
}
