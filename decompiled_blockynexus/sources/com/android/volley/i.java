package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: NetworkDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Request<?>> f4004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f4005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f4006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final n f4007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f4008e = false;

    public i(BlockingQueue<Request<?>> blockingQueue, h hVar, a aVar, n nVar) {
        this.f4004a = blockingQueue;
        this.f4005b = hVar;
        this.f4006c = aVar;
        this.f4007d = nVar;
    }

    @TargetApi(14)
    private void b(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.s());
        }
    }

    public void a() {
        this.f4008e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f4008e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                p.b("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        a(this.f4004a.take());
    }

    void a(Request<?> request) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            request.a("network-queue-take");
            if (request.v()) {
                request.b("network-discard-cancelled");
                request.x();
                return;
            }
            b(request);
            j jVarA = this.f4005b.a(request);
            request.a("network-http-complete");
            if (jVarA.f4013e && request.u()) {
                request.b("not-modified");
                request.x();
                return;
            }
            m<?> mVarA = request.a(jVarA);
            request.a("network-parse-complete");
            if (request.y() && mVarA.f4025b != null) {
                this.f4006c.a(request.d(), mVarA.f4025b);
                request.a("network-cache-written");
            }
            request.w();
            this.f4007d.a(request, mVarA);
            request.a(mVarA);
        } catch (VolleyError e2) {
            e2.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
            a(request, e2);
            request.x();
        } catch (Exception e3) {
            p.a(e3, "Unhandled exception %s", e3.toString());
            VolleyError volleyError = new VolleyError(e3);
            volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.f4007d.a(request, volleyError);
            request.x();
        }
    }

    private void a(Request<?> request, VolleyError volleyError) {
        request.b(volleyError);
        this.f4007d.a(request, volleyError);
    }
}
