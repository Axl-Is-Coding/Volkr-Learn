package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* JADX INFO: compiled from: CrashHandler.java */
/* JADX INFO: loaded from: classes5.dex */
public class n implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f20916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private r f20917b;

    public n() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f20916a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(r rVar) {
        this.f20917b = rVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f20916a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f20916a.uncaughtException(thread, th);
    }

    private void a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f20917b.a(th);
        } else {
            this.f20917b.a(null);
        }
    }
}
