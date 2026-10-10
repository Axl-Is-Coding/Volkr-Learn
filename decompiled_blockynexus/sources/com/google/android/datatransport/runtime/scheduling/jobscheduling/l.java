package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class l implements a.InterfaceC0103a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f12999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f13000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13001c;

    private l(m mVar, com.google.android.datatransport.runtime.q qVar, int i) {
        this.f12999a = mVar;
        this.f13000b = qVar;
        this.f13001c = i;
    }

    public static a.InterfaceC0103a a(m mVar, com.google.android.datatransport.runtime.q qVar, int i) {
        return new l(mVar, qVar, i);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0103a
    public Object execute() {
        return m.a(this.f12999a, this.f13000b, this.f13001c);
    }
}
