package com.alibaba.sdk.android.feedback.a;

import com.alibaba.sdk.android.feedback.util.IWxCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f3693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IWxCallback f3694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f3695c;

    g(c cVar, Map map, IWxCallback iWxCallback) {
        this.f3695c = cVar;
        this.f3693a = map;
        this.f3694b = iWxCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.alibaba.sdk.android.feedback.util.a.b(this.f3693a, this.f3694b, b.k() + "/getUnreadCount.do").a();
    }
}
