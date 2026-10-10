package com.alibaba.sdk.android.feedback.xblink.f.a;

/* JADX INFO: loaded from: classes.dex */
class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f3825a;

    s(q qVar) {
        this.f3825a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        mVar.a("HY_FAILED");
        if (this.f3825a.f3819a.g != null) {
            this.f3825a.f3819a.g.b(mVar);
        }
    }
}
