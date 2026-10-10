package com.alibaba.sdk.android.feedback.xblink.f.a;

/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f3813a;

    m(l lVar) {
        this.f3813a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        com.alibaba.sdk.android.feedback.util.n.a("AudioPlaySuccess", null);
        if (this.f3813a.f3812c.f3807d != null) {
            this.f3813a.f3812c.f3807d.a(mVar);
        }
    }
}
