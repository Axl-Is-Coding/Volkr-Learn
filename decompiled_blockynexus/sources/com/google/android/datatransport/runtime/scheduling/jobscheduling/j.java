package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class j implements a.InterfaceC0103a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f12993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BackendResponse f12994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Iterable f12995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12997e;

    private j(m mVar, BackendResponse backendResponse, Iterable iterable, com.google.android.datatransport.runtime.q qVar, int i) {
        this.f12993a = mVar;
        this.f12994b = backendResponse;
        this.f12995c = iterable;
        this.f12996d = qVar;
        this.f12997e = i;
    }

    public static a.InterfaceC0103a a(m mVar, BackendResponse backendResponse, Iterable iterable, com.google.android.datatransport.runtime.q qVar, int i) {
        return new j(mVar, backendResponse, iterable, qVar, i);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0103a
    public Object execute() {
        return m.a(this.f12993a, this.f12994b, this.f12995c, this.f12996d, this.f12997e);
    }
}
