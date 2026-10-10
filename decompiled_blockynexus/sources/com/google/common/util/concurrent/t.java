package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ThreadFactoryBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f14079b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f14080c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f14081d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ThreadFactory f14082e = null;

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public t a(String str) {
        b(str, 0);
        this.f14078a = str;
        return this;
    }

    public t a(boolean z) {
        this.f14079b = Boolean.valueOf(z);
        return this;
    }

    public ThreadFactory a() {
        return a(this);
    }

    private static ThreadFactory a(t tVar) {
        String str = tVar.f14078a;
        Boolean bool = tVar.f14079b;
        Integer num = tVar.f14080c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = tVar.f14081d;
        ThreadFactory threadFactoryDefaultThreadFactory = tVar.f14082e;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        return new s(threadFactoryDefaultThreadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }
}
