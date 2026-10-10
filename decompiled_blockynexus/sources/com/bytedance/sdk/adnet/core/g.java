package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: ExecutorDelivery.java */
/* JADX INFO: loaded from: classes.dex */
class g implements com.bytedance.sdk.adnet.face.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f5511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f5512b = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.sdk.adnet.c.c f5513c = com.bytedance.sdk.adnet.c.f.a();

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Request f5516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m f5517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f5518c;

        public a(Request request, m mVar, Runnable runnable) {
            this.f5516a = request;
            this.f5517b = mVar;
            this.f5518c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5516a.isCanceled()) {
                this.f5516a.a("canceled-at-delivery");
                return;
            }
            this.f5517b.g = this.f5516a.getExtra();
            this.f5517b.a(SystemClock.elapsedRealtime() - this.f5516a.getStartTime());
            this.f5517b.b(this.f5516a.getNetDuration());
            try {
                if (this.f5517b.a()) {
                    this.f5516a.a(this.f5517b);
                } else {
                    this.f5516a.deliverError(this.f5517b);
                }
            } catch (Throwable unused) {
            }
            if (this.f5517b.f5541d) {
                this.f5516a.addMarker("intermediate-response");
            } else {
                this.f5516a.a("done");
            }
            Runnable runnable = this.f5518c;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public g(final Handler handler) {
        this.f5511a = new Executor() { // from class: com.bytedance.sdk.adnet.core.g.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    private Executor a(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f5511a : this.f5512b;
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, m<?> mVar) {
        a(request, mVar, null);
        com.bytedance.sdk.adnet.c.c cVar = this.f5513c;
        if (cVar != null) {
            cVar.a(request, mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, m<?> mVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        a(request).execute(new a(request, mVar, runnable));
        com.bytedance.sdk.adnet.c.c cVar = this.f5513c;
        if (cVar != null) {
            cVar.a(request, mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        a(request).execute(new a(request, m.a(vAdError), null));
        com.bytedance.sdk.adnet.c.c cVar = this.f5513c;
        if (cVar != null) {
            cVar.a(request, vAdError);
        }
    }
}
