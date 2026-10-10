package com.alibaba.sdk.android.feedback.xblink.f.a;

/* JADX INFO: loaded from: classes.dex */
class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f3814a;

    n(l lVar) {
        this.f3814a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        com.alibaba.sdk.android.feedback.util.n.a("AudioPlayFailed", null);
        if (this.f3814a.f3812c.f3807d != null) {
            this.f3814a.f3812c.f3807d.b(mVar);
        }
    }
}
