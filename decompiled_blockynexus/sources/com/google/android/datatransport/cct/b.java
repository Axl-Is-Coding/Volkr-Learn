package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.d;

/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class b implements com.google.android.datatransport.runtime.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f12730a;

    private b(d dVar) {
        this.f12730a = dVar;
    }

    public static com.google.android.datatransport.runtime.c.a a(d dVar) {
        return new b(dVar);
    }

    @Override // com.google.android.datatransport.runtime.c.a
    public Object apply(Object obj) {
        return this.f12730a.a((d.a) obj);
    }
}
