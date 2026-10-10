package com.bytedance.sdk.adnet.core;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: NetworkDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
class h extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Request<?>> f5519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.b f5520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.a f5521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.c f5522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f5523e = false;

    public h(BlockingQueue<Request<?>> blockingQueue, com.bytedance.sdk.adnet.face.b bVar, com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.c cVar) {
        this.f5519a = blockingQueue;
        this.f5520b = bVar;
        this.f5521c = aVar;
        this.f5522d = cVar;
    }

    @TargetApi(14)
    private void b(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    public void a() {
        this.f5523e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f5523e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        a(this.f5519a.take());
    }

    void a(Request<?> request) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        request.a(3);
        try {
            try {
                request.addMarker("network-queue-take");
            } catch (VAdError e2) {
                e2.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                a(request, e2);
                request.e();
            } catch (Exception e3) {
                o.a(e3, "Unhandled exception %s", e3.toString());
                VAdError vAdError = new VAdError(e3);
                vAdError.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.f5522d.a(request, vAdError);
                request.e();
            } catch (Throwable th) {
                o.a(th, "NetworkDispatcher Unhandled throwable %s", th.toString());
                VAdError vAdError2 = new VAdError(th);
                vAdError2.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.f5522d.a(request, vAdError2);
                request.e();
            }
            if (request.isCanceled()) {
                request.a("network-discard-cancelled");
                request.e();
                return;
            }
            b(request);
            i iVarA = this.f5520b.a(request);
            request.setNetDuration(iVarA.f5529f);
            request.addMarker("network-http-complete");
            if (iVarA.f5528e && request.hasHadResponseDelivered()) {
                request.a("not-modified");
                request.e();
                return;
            }
            m<?> mVarA = request.a(iVarA);
            request.setNetDuration(iVarA.f5529f);
            request.addMarker("network-parse-complete");
            if (request.shouldCache() && mVarA.f5539b != null) {
                this.f5521c.a(request.getCacheKey(), mVarA.f5539b);
                request.addMarker("network-cache-written");
            }
            request.markDelivered();
            this.f5522d.a(request, mVarA);
            request.b(mVarA);
        } finally {
            request.a(4);
        }
    }

    private void a(Request<?> request, VAdError vAdError) {
        this.f5522d.a(request, request.a(vAdError));
    }
}
