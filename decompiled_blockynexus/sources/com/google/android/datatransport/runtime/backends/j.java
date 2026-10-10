package com.google.android.datatransport.runtime.backends;

import android.content.Context;

/* JADX INFO: compiled from: CreationContextFactory_Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements com.google.android.datatransport.runtime.a.a.b<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<Context> f12827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.e.a> f12828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.e.a> f12829c;

    public j(e.a.a<Context> aVar, e.a.a<com.google.android.datatransport.runtime.e.a> aVar2, e.a.a<com.google.android.datatransport.runtime.e.a> aVar3) {
        this.f12827a = aVar;
        this.f12828b = aVar2;
        this.f12829c = aVar3;
    }

    public static j a(e.a.a<Context> aVar, e.a.a<com.google.android.datatransport.runtime.e.a> aVar2, e.a.a<com.google.android.datatransport.runtime.e.a> aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i a(Context context, com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // e.a.a
    public i get() {
        return a(this.f12827a.get(), this.f12828b.get(), this.f12829c.get());
    }
}
