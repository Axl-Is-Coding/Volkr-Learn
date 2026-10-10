package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* JADX INFO: compiled from: PublisherLogger.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends IronSourceLogger {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f14867c;

    public f(d dVar, int i) {
        super("publisher", i);
        this.f14867c = dVar;
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void a(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th != null) {
            b(ironSourceTag, th.getMessage(), 3);
        }
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void b(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        if (this.f14867c != null && str != null) {
            this.f14867c.a(ironSourceTag, str, i);
        }
    }
}
