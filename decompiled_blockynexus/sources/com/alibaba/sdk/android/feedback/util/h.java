package com.alibaba.sdk.android.feedback.util;

/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3720a;

    h(c cVar) {
        this.f3720a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3720a.f3714e != null) {
            this.f3720a.f3714e.getLooper().quit();
            this.f3720a.f3714e = null;
        }
    }
}
