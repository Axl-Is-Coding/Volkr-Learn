package com.google.android.datatransport.runtime.d.a;

import android.content.Context;

/* JADX INFO: compiled from: SchemaManager_Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class K implements com.google.android.datatransport.runtime.a.a.b<J> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<Context> f12875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<String> f12876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a.a<Integer> f12877c;

    public K(e.a.a<Context> aVar, e.a.a<String> aVar2, e.a.a<Integer> aVar3) {
        this.f12875a = aVar;
        this.f12876b = aVar2;
        this.f12877c = aVar3;
    }

    public static K a(e.a.a<Context> aVar, e.a.a<String> aVar2, e.a.a<Integer> aVar3) {
        return new K(aVar, aVar2, aVar3);
    }

    public static J a(Context context, String str, int i) {
        return new J(context, str, i);
    }

    @Override // e.a.a
    public J get() {
        return a(this.f12875a.get(), this.f12876b.get(), this.f12877c.get().intValue());
    }
}
