package com.alibaba.sdk.android.feedback.util;

/* JADX INFO: loaded from: classes.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3719a;

    g(c cVar) {
        this.f3719a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3719a.f3714e.removeCallbacks(this.f3719a.i);
        if (this.f3719a.f3712c) {
            if (this.f3719a.f3711b != null) {
                try {
                    this.f3719a.f3711b.stop();
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
                this.f3719a.f3711b.release();
                this.f3719a.f3711b = null;
            }
            this.f3719a.f3712c = false;
            this.f3719a.f();
        }
    }
}
