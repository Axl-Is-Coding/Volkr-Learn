package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.s;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: UploadTask.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<Integer, c> f3575f;
    private static boolean j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3577e;
    private long startTime = System.currentTimeMillis();

    private c(int i, int i2) {
        this.f3576d = 180000;
        this.f3577e = i;
        this.f3576d = i2;
    }

    private static int a(int i) {
        if (i == 65133) {
            return 11;
        }
        switch (i) {
            case 65501:
                return 6;
            case 65502:
                return 9;
            case 65503:
                return 10;
            default:
                return 0;
        }
    }

    static void a(int i, int i2) {
        i.a("CommitTask", "[setStatisticsInterval] eventId" + i + " statisticsInterval:" + i2);
        synchronized (f3575f) {
            c cVar = f3575f.get(Integer.valueOf(i));
            if (cVar == null) {
                if (i2 > 0) {
                    c cVar2 = new c(i, i2 * 1000);
                    f3575f.put(Integer.valueOf(i), cVar2);
                    i.a("CommitTask", "post next eventId" + i + ": uploadTask.interval " + cVar2.f3576d);
                    s.a().a(a(i), cVar2, (long) cVar2.f3576d);
                }
            } else if (i2 > 0) {
                int i3 = i2 * 1000;
                if (cVar.f3576d != i3) {
                    s.a().f(a(i));
                    cVar.f3576d = i3;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j2 = ((long) cVar.f3576d) - (jCurrentTimeMillis - cVar.startTime);
                    if (j2 < 0) {
                        j2 = 0;
                    }
                    i.a("CommitTask", cVar + "post next eventId" + i + " next:" + j2 + "  uploadTask.interval: " + cVar.f3576d);
                    s.a().a(a(i), cVar, j2);
                    cVar.startTime = jCurrentTimeMillis;
                }
            } else {
                i.a("CommitTask", "uploadTasks.size:" + f3575f.size());
                f3575f.remove(Integer.valueOf(i));
                i.a("CommitTask", "uploadTasks.size:" + f3575f.size());
            }
        }
    }

    static void d() {
        for (f fVar : f.values()) {
            e.a().m13a(fVar.a());
        }
    }

    static void destroy() {
        for (f fVar : f.values()) {
            s.a().f(a(fVar.a()));
        }
        j = false;
        f3575f = null;
    }

    static void init() {
        if (j) {
            return;
        }
        i.a("CommitTask", "init StatisticsAlarmEvent");
        f3575f = new ConcurrentHashMap();
        for (f fVar : f.values()) {
            if (fVar.isOpen()) {
                int iA = fVar.a();
                c cVar = new c(iA, fVar.c() * 1000);
                f3575f.put(Integer.valueOf(iA), cVar);
                s.a().a(a(iA), cVar, cVar.f3576d);
            }
        }
        j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.a("CommitTask", "check&commit event:", Integer.valueOf(this.f3577e));
        e.a().m13a(this.f3577e);
        if (f3575f.containsValue(this)) {
            this.startTime = System.currentTimeMillis();
            i.a("CommitTask", "next:" + this.f3577e);
            s.a().a(a(this.f3577e), this, (long) this.f3576d);
        }
    }
}
