package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutorDelivery.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f3998a;

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Request f3999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m f4000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f4001c;

        public a(Request request, m mVar, Runnable runnable) {
            this.f3999a = request;
            this.f4000b = mVar;
            this.f4001c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3999a.v()) {
                this.f3999a.b("canceled-at-delivery");
                return;
            }
            if (this.f4000b.a()) {
                this.f3999a.a(this.f4000b.f4024a);
            } else {
                this.f3999a.a(this.f4000b.f4026c);
            }
            if (this.f4000b.f4027d) {
                this.f3999a.a("intermediate-response");
            } else {
                this.f3999a.b("done");
            }
            Runnable runnable = this.f4001c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.f3998a = new e(this, handler);
    }

    @Override // com.android.volley.n
    public void a(Request<?> request, m<?> mVar) {
        a(request, mVar, null);
    }

    @Override // com.android.volley.n
    public void a(Request<?> request, m<?> mVar, Runnable runnable) {
        request.w();
        request.a("post-response");
        this.f3998a.execute(new a(request, mVar, runnable));
    }

    @Override // com.android.volley.n
    public void a(Request<?> request, VolleyError volleyError) {
        request.a("post-error");
        this.f3998a.execute(new a(request, m.a(volleyError), null));
    }
}
