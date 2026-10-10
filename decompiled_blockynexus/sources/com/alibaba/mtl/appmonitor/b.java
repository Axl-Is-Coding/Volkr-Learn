package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.s;

/* JADX INFO: compiled from: CleanTask.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f3574a = 300000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f45a;
    private static boolean j;

    private b() {
    }

    static void destroy() {
        s.a().f(5);
        j = false;
        f45a = null;
    }

    static void init() {
        if (j) {
            return;
        }
        i.a("CleanTask", "init TimeoutEventManager");
        f45a = new b();
        s.a().a(5, f45a, f3574a);
        j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.a("CleanTask", "clean TimeoutEvent");
        e.a().g();
        s.a().a(5, f45a, f3574a);
    }
}
