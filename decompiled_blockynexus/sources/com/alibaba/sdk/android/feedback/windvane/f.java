package com.alibaba.sdk.android.feedback.windvane;

import com.alibaba.sdk.android.feedback.xblink.webview.v;

/* JADX INFO: loaded from: classes.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f3742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f3743b;

    f(e eVar, v vVar) {
        this.f3743b = eVar;
        this.f3742a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3742a.e();
    }
}
