package com.google.android.datatransport.runtime.d;

import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.q;

/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f12847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f12848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.g f12849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l f12850d;

    private a(c cVar, q qVar, com.google.android.datatransport.g gVar, l lVar) {
        this.f12847a = cVar;
        this.f12848b = qVar;
        this.f12849c = gVar;
        this.f12850d = lVar;
    }

    public static Runnable a(c cVar, q qVar, com.google.android.datatransport.g gVar, l lVar) {
        return new a(cVar, qVar, gVar, lVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        c.a(this.f12847a, this.f12848b, this.f12849c, this.f12850d);
    }
}
