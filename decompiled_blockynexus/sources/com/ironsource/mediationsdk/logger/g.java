package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.lang.Thread;

/* JADX INFO: compiled from: ThreadExceptionHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "Thread name =" + thread.getName(), th);
    }
}
