package com.ironsource.mediationsdk.b;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;

/* JADX INFO: compiled from: BaseEventsManager.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f14775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f14776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f14777c;

    c(d dVar, boolean z, ArrayList arrayList) {
        this.f14777c = dVar;
        this.f14775a = z;
        this.f14776b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14775a) {
            ArrayList<b.f.b.b> arrayListC = this.f14777c.f14778a.m.c(this.f14777c.f14778a.F);
            this.f14777c.f14778a.q = arrayListC.size() + this.f14777c.f14778a.o.size();
        } else if (this.f14776b != null) {
            this.f14777c.f14778a.K.b(IronSourceLogger.IronSourceTag.INTERNAL, "Failed to send events", 0);
            this.f14777c.f14778a.m.a(this.f14776b, this.f14777c.f14778a.F);
            ArrayList<b.f.b.b> arrayListC2 = this.f14777c.f14778a.m.c(this.f14777c.f14778a.F);
            this.f14777c.f14778a.q = arrayListC2.size() + this.f14777c.f14778a.o.size();
        }
    }
}
