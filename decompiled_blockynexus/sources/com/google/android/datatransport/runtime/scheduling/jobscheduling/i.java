package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class i implements a.InterfaceC0103a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f12991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12992b;

    private i(m mVar, com.google.android.datatransport.runtime.q qVar) {
        this.f12991a = mVar;
        this.f12992b = qVar;
    }

    public static a.InterfaceC0103a a(m mVar, com.google.android.datatransport.runtime.q qVar) {
        return new i(mVar, qVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0103a
    public Object execute() {
        return this.f12991a.f13004c.c(this.f12992b);
    }
}
