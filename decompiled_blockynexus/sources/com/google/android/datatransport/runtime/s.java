package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.p;

/* JADX INFO: compiled from: TransportImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class s<T> implements com.google.android.datatransport.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f12961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.b f12963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.d<T, byte[]> f12964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f12965e;

    s(q qVar, String str, com.google.android.datatransport.b bVar, com.google.android.datatransport.d<T, byte[]> dVar, t tVar) {
        this.f12961a = qVar;
        this.f12962b = str;
        this.f12963c = bVar;
        this.f12964d = dVar;
        this.f12965e = tVar;
    }

    @Override // com.google.android.datatransport.e
    public void a(com.google.android.datatransport.c<T> cVar, com.google.android.datatransport.g gVar) {
        t tVar = this.f12965e;
        p.a aVarA = p.a();
        aVarA.a(this.f12961a);
        aVarA.a((com.google.android.datatransport.c<?>) cVar);
        aVarA.a(this.f12962b);
        aVarA.a((com.google.android.datatransport.d<?, byte[]>) this.f12964d);
        aVarA.a(this.f12963c);
        tVar.a(aVarA.a(), gVar);
    }
}
