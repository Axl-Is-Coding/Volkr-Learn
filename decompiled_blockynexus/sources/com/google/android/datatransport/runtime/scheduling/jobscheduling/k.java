package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class k implements a.InterfaceC0103a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2220d f12998a;

    private k(InterfaceC2220d interfaceC2220d) {
        this.f12998a = interfaceC2220d;
    }

    public static a.InterfaceC0103a a(InterfaceC2220d interfaceC2220d) {
        return new k(interfaceC2220d);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0103a
    public Object execute() {
        return Integer.valueOf(this.f12998a.G());
    }
}
