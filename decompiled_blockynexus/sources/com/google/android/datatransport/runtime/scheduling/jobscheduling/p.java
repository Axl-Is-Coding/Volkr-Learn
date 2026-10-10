package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: compiled from: WorkInitializer.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class p implements a.InterfaceC0103a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f13015a;

    private p(q qVar) {
        this.f13015a = qVar;
    }

    public static a.InterfaceC0103a a(q qVar) {
        return new p(qVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0103a
    public Object execute() {
        return q.a(this.f13015a);
    }
}
