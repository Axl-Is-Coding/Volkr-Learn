package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BaseProgManager.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2337o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ironsource.mediationsdk.c.c f14956a;

    public AbstractC2337o(com.ironsource.mediationsdk.c.c cVar) {
        this.f14956a = cVar;
    }

    protected void a(boolean z, C2325i c2325i, String str) {
        if (c2325i == null || this.f14956a == null) {
            IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
            return;
        }
        com.ironsource.mediationsdk.c.a aVarA = c2325i.a(str);
        if (aVarA != null) {
            if (z) {
                IronLog.CALLBACK.info("onImpressionSuccess: " + aVarA);
                this.f14956a.a(aVarA);
                return;
            }
            IronLog.CALLBACK.info("onImpressionFailure: " + aVarA);
            this.f14956a.b(aVarA);
        }
    }
}
