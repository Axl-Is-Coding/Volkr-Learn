package com.ironsource.mediationsdk.b;

import java.util.ArrayList;

/* JADX INFO: compiled from: BaseEventsManager.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements b.f.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f14778a;

    d(f fVar) {
        this.f14778a = fVar;
    }

    @Override // b.f.b.e
    public synchronized void a(ArrayList<b.f.b.b> arrayList, boolean z) {
        this.f14778a.H.a(new c(this, z, arrayList));
    }
}
