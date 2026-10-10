package com.google.android.datatransport.runtime.backends;

import android.content.Context;

/* JADX INFO: compiled from: MetadataBackendRegistry_Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements com.google.android.datatransport.runtime.a.a.b<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<Context> f12835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<i> f12836b;

    public l(e.a.a<Context> aVar, e.a.a<i> aVar2) {
        this.f12835a = aVar;
        this.f12836b = aVar2;
    }

    public static l a(e.a.a<Context> aVar, e.a.a<i> aVar2) {
        return new l(aVar, aVar2);
    }

    public static k a(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // e.a.a
    public k get() {
        return a(this.f12835a.get(), this.f12836b.get());
    }
}
