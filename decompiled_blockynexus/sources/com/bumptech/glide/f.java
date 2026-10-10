package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideContext.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final l<?, ?> f4179a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Registry f4181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.request.target.e f4182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c.a f4183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<com.bumptech.glide.request.e<Object>> f4184f;
    private final Map<Class<?>, l<?, ?>> g;
    private final r h;
    private final boolean i;
    private final int j;
    private com.bumptech.glide.request.f k;

    public f(Context context, com.bumptech.glide.load.engine.a.b bVar, Registry registry, com.bumptech.glide.request.target.e eVar, c.a aVar, Map<Class<?>, l<?, ?>> map, List<com.bumptech.glide.request.e<Object>> list, r rVar, boolean z, int i) {
        super(context.getApplicationContext());
        this.f4180b = bVar;
        this.f4181c = registry;
        this.f4182d = eVar;
        this.f4183e = aVar;
        this.f4184f = list;
        this.g = map;
        this.h = rVar;
        this.i = z;
        this.j = i;
    }

    public <T> l<?, T> a(Class<T> cls) {
        l<?, T> lVar = (l) this.g.get(cls);
        if (lVar == null) {
            for (Map.Entry<Class<?>, l<?, ?>> entry : this.g.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    lVar = (l) entry.getValue();
                }
            }
        }
        return lVar == null ? (l<?, T>) f4179a : lVar;
    }

    public List<com.bumptech.glide.request.e<Object>> b() {
        return this.f4184f;
    }

    public synchronized com.bumptech.glide.request.f c() {
        if (this.k == null) {
            this.k = this.f4183e.build().lock();
        }
        return this.k;
    }

    public r d() {
        return this.h;
    }

    public int e() {
        return this.j;
    }

    public Registry f() {
        return this.f4181c;
    }

    public boolean g() {
        return this.i;
    }

    public <X> ViewTarget<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f4182d.a(imageView, cls);
    }

    public com.bumptech.glide.load.engine.a.b a() {
        return this.f4180b;
    }
}
