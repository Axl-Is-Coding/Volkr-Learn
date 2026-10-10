package com.google.android.datatransport.runtime.d;

import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.q;
import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class b implements a.InterfaceC0103a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f12917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f12918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f12919c;

    private b(c cVar, q qVar, l lVar) {
        this.f12917a = cVar;
        this.f12918b = qVar;
        this.f12919c = lVar;
    }

    public static a.InterfaceC0103a a(c cVar, q qVar, l lVar) {
        return new b(cVar, qVar, lVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0103a
    public Object execute() {
        return c.a(this.f12917a, this.f12918b, this.f12919c);
    }
}
