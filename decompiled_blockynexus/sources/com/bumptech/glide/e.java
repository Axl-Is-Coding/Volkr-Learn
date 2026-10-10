package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.b.a;
import com.bumptech.glide.load.engine.b.j;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.manager.m;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private r f4143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.e f4144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.b f4145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.engine.b.i f4146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.load.engine.c.a f4147f;
    private com.bumptech.glide.load.engine.c.a g;
    private a.InterfaceC0061a h;
    private com.bumptech.glide.load.engine.b.j i;
    private com.bumptech.glide.manager.d j;
    private m.a m;
    private com.bumptech.glide.load.engine.c.a n;
    private boolean o;
    private List<com.bumptech.glide.request.e<Object>> p;
    private boolean q;
    private boolean r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, l<?, ?>> f4142a = new a.a.b();
    private int k = 4;
    private c.a l = new d(this);

    void a(m.a aVar) {
        this.m = aVar;
    }

    c a(Context context) {
        if (this.f4147f == null) {
            this.f4147f = com.bumptech.glide.load.engine.c.a.g();
        }
        if (this.g == null) {
            this.g = com.bumptech.glide.load.engine.c.a.e();
        }
        if (this.n == null) {
            this.n = com.bumptech.glide.load.engine.c.a.c();
        }
        if (this.i == null) {
            this.i = new j.a(context).a();
        }
        if (this.j == null) {
            this.j = new com.bumptech.glide.manager.g();
        }
        if (this.f4144c == null) {
            int iB = this.i.b();
            if (iB > 0) {
                this.f4144c = new com.bumptech.glide.load.engine.a.k(iB);
            } else {
                this.f4144c = new com.bumptech.glide.load.engine.a.f();
            }
        }
        if (this.f4145d == null) {
            this.f4145d = new com.bumptech.glide.load.engine.a.j(this.i.a());
        }
        if (this.f4146e == null) {
            this.f4146e = new com.bumptech.glide.load.engine.b.h(this.i.c());
        }
        if (this.h == null) {
            this.h = new com.bumptech.glide.load.engine.b.g(context);
        }
        if (this.f4143b == null) {
            this.f4143b = new r(this.f4146e, this.h, this.g, this.f4147f, com.bumptech.glide.load.engine.c.a.h(), this.n, this.o);
        }
        List<com.bumptech.glide.request.e<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        return new c(context, this.f4143b, this.f4146e, this.f4144c, this.f4145d, new m(this.m), this.j, this.k, this.l, this.f4142a, this.p, this.q, this.r);
    }
}
