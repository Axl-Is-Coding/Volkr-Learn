package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: WorkInitializer.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f13016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2220d f13017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f13018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f13019d;

    q(Executor executor, InterfaceC2220d interfaceC2220d, s sVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        this.f13016a = executor;
        this.f13017b = interfaceC2220d;
        this.f13018c = sVar;
        this.f13019d = aVar;
    }

    public void a() {
        this.f13016a.execute(o.a(this));
    }

    static /* synthetic */ Object a(q qVar) {
        Iterator<com.google.android.datatransport.runtime.q> it = qVar.f13017b.I().iterator();
        while (it.hasNext()) {
            qVar.f13018c.a(it.next(), 1);
        }
        return null;
    }
}
